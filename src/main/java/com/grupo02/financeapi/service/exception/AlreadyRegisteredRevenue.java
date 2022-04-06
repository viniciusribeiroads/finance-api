package com.grupo02.financeapi.service.exception;

public class AlreadyRegisteredRevenue extends RuntimeException{

    public AlreadyRegisteredRevenue(String msg) {
        super(msg);
    }

    public AlreadyRegisteredRevenue(String msg, Throwable cause) {
        super(msg, cause);
    }
}
