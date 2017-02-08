package com.springHello.exception;

/**
 * Created by mar1 on 2/8/17.
 */
public class ErrorInfo {

    private int errorCode;
    private String message;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorInfo(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
}
