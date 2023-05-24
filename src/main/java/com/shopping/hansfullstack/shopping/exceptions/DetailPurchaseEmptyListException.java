package com.shopping.hansfullstack.shopping.exceptions;

public class DetailPurchaseEmptyListException extends RuntimeException{

    public DetailPurchaseEmptyListException () {
        super("Purchase has an empty list");
    }

}
