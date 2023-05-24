package com.shopping.hansfullstack.shopping.services;

import com.shopping.hansfullstack.shopping.entities.Supplier;
import com.shopping.hansfullstack.shopping.exceptions.DetailPurchaseEmptyListException;
import com.shopping.hansfullstack.shopping.exceptions.NoSuchSupplierException;
import com.shopping.hansfullstack.shopping.repositories.SupplierRepository;
import com.shopping.hansfullstack.shopping.request.AddPurchaseDTO;
import com.shopping.hansfullstack.shopping.response.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService{

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public ResponseDTO addPurchaseOfClothes(AddPurchaseDTO addPurchaseDTO) {
        if (addPurchaseDTO.getItems().isEmpty()) throw new DetailPurchaseEmptyListException();

        Long idSupplier = addPurchaseDTO.getIdSupplier();

        supplierRepository.findById(idSupplier)
                .orElseThrow(() -> new NoSuchSupplierException(idSupplier));

        return ResponseDTO.builder().status(HttpStatus.OK).build();
    }

    // Validate if any item no such
}
