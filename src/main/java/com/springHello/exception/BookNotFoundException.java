package com.springHello.exception;

/**
 * Created by mar1 on 2/3/17.
 */


public class BookNotFoundException  extends RuntimeException {

    public BookNotFoundException(String message) {
        super(message);
    }
}
