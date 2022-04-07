package com.grupo02.financeapi.service.exception;

public class AlreadyRegisteredRevenueException extends RuntimeException{

    public AlreadyRegisteredRevenueException(String msg) {
        super(msg);
    }

    public AlreadyRegisteredRevenueException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
