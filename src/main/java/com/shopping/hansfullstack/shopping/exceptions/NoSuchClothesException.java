package com.shopping.hansfullstack.shopping.exceptions;

public class NoSuchClothesException extends RuntimeException{

    private String message;

    public NoSuchClothesException() {}

    public NoSuchClothesException (String msg) {
        super(msg);
        this.message = msg;
    }

}
