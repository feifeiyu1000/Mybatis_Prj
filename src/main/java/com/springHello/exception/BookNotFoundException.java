package com.springHello.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by mar1 on 2/3/17.
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Book Not Found")
public class BookNotFoundException  extends RuntimeException {

    public BookNotFoundException() {
        super();
    }
}
