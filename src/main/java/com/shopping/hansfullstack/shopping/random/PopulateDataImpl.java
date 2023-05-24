package com.shopping.hansfullstack.shopping.random;

import com.shopping.hansfullstack.shopping.entities.Clothes;
import com.shopping.hansfullstack.shopping.entities.Stock;
import com.shopping.hansfullstack.shopping.entities.Supplier;
import com.shopping.hansfullstack.shopping.repositories.ClothesRepository;
import com.shopping.hansfullstack.shopping.repositories.StockRepository;
import com.shopping.hansfullstack.shopping.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PopulateDataImpl implements PopulateData{

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
        for (int i = 0; i < 10; i++) {
            Clothes clothes = clothesRepository.save(randomDataClothes.getRandomClothes());
            stockRepository.save(Stock.builder().clothes(clothes).amount(1).build());
        }
    }

    @Override
    public void populateSuppliers() {
        for (int i = 0; i < 10; i++) {
            supplierRepository.save(randomDataClothes.getRandomSupplier());
        }
    }
}
