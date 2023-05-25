package com.shopping.hansfullstack.shopping.services;

import com.shopping.hansfullstack.shopping.models.UpdateStock;

import java.util.List;

public interface StockService {

    void updateSomeStocks (List<UpdateStock> stocks);

}
