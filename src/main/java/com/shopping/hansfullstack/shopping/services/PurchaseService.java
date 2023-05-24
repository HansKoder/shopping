package com.shopping.hansfullstack.shopping.services;

import com.shopping.hansfullstack.shopping.request.AddPurchaseDTO;
import com.shopping.hansfullstack.shopping.response.ResponseDTO;

public interface PurchaseService {

    ResponseDTO addPurchaseOfClothes(AddPurchaseDTO addPurchaseDTO);

}
