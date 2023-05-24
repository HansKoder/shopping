package com.shopping.hansfullstack.shopping.controllers;

import com.shopping.hansfullstack.shopping.exceptions.DetailPurchaseEmptyListException;
import com.shopping.hansfullstack.shopping.exceptions.ErrorResponse;
import com.shopping.hansfullstack.shopping.exceptions.NoSuchSupplierException;
import com.shopping.hansfullstack.shopping.request.AddPurchaseDTO;
import com.shopping.hansfullstack.shopping.response.ResponseDTO;
import com.shopping.hansfullstack.shopping.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("/")
    public ResponseDTO addPurchase(@RequestBody AddPurchaseDTO addPurchaseDTO){
        return purchaseService.addPurchaseOfClothes(addPurchaseDTO);
    }

    @ExceptionHandler(value = DetailPurchaseEmptyListException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handlePurchaseEmptyListException (DetailPurchaseEmptyListException ex) {
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }

    @ExceptionHandler(value = NoSuchSupplierException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNoSuchSupplierException (NoSuchSupplierException ex) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

}
