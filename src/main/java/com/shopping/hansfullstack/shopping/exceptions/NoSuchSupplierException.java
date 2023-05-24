package com.shopping.hansfullstack.shopping.exceptions;

public class NoSuchSupplierException extends RuntimeException{

    public NoSuchSupplierException (Long id) {
        super("No Such Supplier with the ID " + id);
    }

}
