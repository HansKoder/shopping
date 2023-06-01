package com.shopping.hansfullstack.shopping.services;

import com.shopping.hansfullstack.shopping.entities.Order;
import com.shopping.hansfullstack.shopping.request.AddPurchaseDTO;
import com.shopping.hansfullstack.shopping.response.ResponseDTO;

import java.util.List;

public interface OrderService {

    ResponseDTO addPurchaseOfClothes(AddPurchaseDTO addPurchaseDTO);

    List<Order> getPurchases ();

}
