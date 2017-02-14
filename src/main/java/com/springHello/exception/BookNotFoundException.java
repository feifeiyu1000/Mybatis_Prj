package com.springHello.exception;

/**
 * Created by mar1 on 2/3/17.
 */

public class BookNotFoundException  extends Exception {

    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public BookNotFoundException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public BookNotFoundException() {
        super();
    }
}
