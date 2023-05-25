package com.shopping.hansfullstack.shopping.services.imp;

import com.shopping.hansfullstack.shopping.entities.Clothes;
import com.shopping.hansfullstack.shopping.entities.Stock;
import com.shopping.hansfullstack.shopping.models.UpdateStock;
import com.shopping.hansfullstack.shopping.repositories.StockRepository;
import com.shopping.hansfullstack.shopping.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;

    @Override
    public void updateSomeStocks(List<UpdateStock> stocks) {
        stocks.forEach( stock -> updateStockByClothesId(stock));
    }

    private Stock updateStockByClothesId (UpdateStock updateStock) {
        Long clothesId = updateStock.getClothesId();
        Optional<Stock> stockOptional = stockRepository.findByClothesId(clothesId);

        if (stockOptional.isEmpty()) return addStock(updateStock);

        Stock stockEntity = stockOptional.get();
        stockEntity.setAmount(stockEntity.getAmount() + updateStock.getCount());

        return stockRepository.save(stockEntity);
    }

    private Stock addStock (UpdateStock updateStock) {
        Clothes clothes = Clothes.builder().id(updateStock.getClothesId()).build();

        Stock stockEntity = Stock.builder()
                .clothes(clothes)
                .amount(updateStock.getCount())
                .build();

        return stockRepository.save(stockEntity);
    }
}
