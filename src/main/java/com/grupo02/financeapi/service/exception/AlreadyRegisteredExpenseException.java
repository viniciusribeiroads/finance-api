package com.grupo02.financeapi.service.exception;

public class AlreadyRegisteredExpenseException extends RuntimeException{

    public AlreadyRegisteredExpenseException(String msg){
        super(msg);
    }
}
