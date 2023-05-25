package com.shopping.hansfullstack.shopping.services.imp;

import com.shopping.hansfullstack.shopping.entities.Clothes;
import com.shopping.hansfullstack.shopping.entities.DetailPurchase;
import com.shopping.hansfullstack.shopping.entities.Purchase;
import com.shopping.hansfullstack.shopping.entities.Supplier;
import com.shopping.hansfullstack.shopping.exceptions.DetailPurchaseEmptyListException;
import com.shopping.hansfullstack.shopping.exceptions.NoSuchClothesException;
import com.shopping.hansfullstack.shopping.exceptions.NoSuchSupplierException;
import com.shopping.hansfullstack.shopping.models.UpdateStock;
import com.shopping.hansfullstack.shopping.repositories.ClothesRepository;
import com.shopping.hansfullstack.shopping.repositories.DetailPurchaseRepository;
import com.shopping.hansfullstack.shopping.repositories.PurchaseRepository;
import com.shopping.hansfullstack.shopping.repositories.SupplierRepository;
import com.shopping.hansfullstack.shopping.request.AddPurchaseDTO;
import com.shopping.hansfullstack.shopping.request.DetailPurchaseDTO;
import com.shopping.hansfullstack.shopping.response.ResponseDTO;
import com.shopping.hansfullstack.shopping.services.PurchaseService;
import com.shopping.hansfullstack.shopping.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private ClothesRepository clothesRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private DetailPurchaseRepository detailPurchaseRepository;

    @Autowired
    private StockService stockService;

    @Override
    public ResponseDTO addPurchaseOfClothes(AddPurchaseDTO addPurchaseDTO) {
        // There are not anything item
        if (addPurchaseDTO.getItems().isEmpty()) throw new DetailPurchaseEmptyListException();

        // Supplier no such
        Long idSupplier = addPurchaseDTO.getIdSupplier();
        supplierRepository.findById(idSupplier)
                .orElseThrow(() -> new NoSuchSupplierException(idSupplier));

        // Items no such
        List<Long> ids = addPurchaseDTO.getItems().stream().map(item -> item.getClothesId()).toList();
        validateNoSuchClothes(ids);

        // Save data
        Purchase addPurchase = purchaseRepository.save(mapPurchase(addPurchaseDTO, idSupplier));
        detailPurchaseRepository.saveAll(mapItems(addPurchaseDTO.getItems(), addPurchase));

        // Modify stock
        stockService.updateSomeStocks(mapStocks(addPurchaseDTO.getItems()));

        return ResponseDTO.builder().status(HttpStatus.OK).message("success").build();
    }

    private Purchase mapPurchase (AddPurchaseDTO addPurchaseDTO, Long idSupplier) {
        return Purchase.builder()
                .datePurchase(new Date())
                .total(addPurchaseDTO.getTotal())
                .comments(addPurchaseDTO.getComments())
                .supplier(Supplier.builder().id(idSupplier).build())
                .build();
    }

    private List<DetailPurchase> mapItems (List<DetailPurchaseDTO> items, Purchase addPurchase) {
        return items.stream()
                .map( item -> {
                    return DetailPurchase.builder()
                            .purchase(addPurchase)
                            .countItems(item.getCount())
                            .clothes(Clothes.builder().id(item.getClothesId()).build())
                            .pricePerUnit(item.getPricePerUnit())
                            .total(item.getTotal())
                            .build();
                })
                .toList();
    }

    private List<UpdateStock> mapStocks (List<DetailPurchaseDTO> items) {
        return items.stream()
                .map(item -> {
                    return UpdateStock.builder()
                            .clothesId(item.getClothesId())
                            .count(item.getCount())
                            .build();
                })
                .toList();
    }

    private void validateNoSuchClothes (List<Long> clothesIds) {
        clothesIds.forEach(id -> {
            clothesRepository
                    .findById(id)
                    .orElseThrow(() -> new NoSuchClothesException("No such item with the ID " + id));
        });
    }

    // Validate if any item no such
}
