package com.shopping.hansfullstack.shopping.random;

import com.shopping.hansfullstack.shopping.entities.Clothes;
import com.shopping.hansfullstack.shopping.entities.Stock;
import com.shopping.hansfullstack.shopping.repositories.ClothesRepository;
import com.shopping.hansfullstack.shopping.repositories.StockRepository;
import com.shopping.hansfullstack.shopping.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PopulateDataImpl implements PopulateData{

    private final int MAX_CLOTHES = 5;
    private final int MAX_SUPPLIERS = 2;

    @Autowired
    private RandomDataClothes randomDataClothes;

    @Autowired
    private ClothesRepository clothesRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public void populateClothes() {
        for (int i = 0; i < MAX_CLOTHES; i++) {
            Clothes clothes = clothesRepository.save(randomDataClothes.getRandomClothes());
            stockRepository.save(Stock.builder().clothes(clothes).amount(1).build());
        }
    }

    @Override
    public void populateSuppliers() {
        for (int i = 0; i < MAX_SUPPLIERS; i++) {
            supplierRepository.save(randomDataClothes.getRandomSupplier());
        }
    }
}
