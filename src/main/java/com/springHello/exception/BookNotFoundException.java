package com.springHello.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

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
