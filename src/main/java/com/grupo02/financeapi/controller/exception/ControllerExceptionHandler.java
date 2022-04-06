package com.grupo02.financeapi.controller.exception;

import com.grupo02.financeapi.service.exception.AlreadyRegisteredRevenue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(AlreadyRegisteredRevenue.class)
    public ResponseEntity<StandardError> alreadyRegisteredRevenue(AlreadyRegisteredRevenue e, HttpServletRequest request) {
        StandardError err = new StandardError(HttpStatus.UNAUTHORIZED.value(),
                e.getMessage(),
                System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(err);
    }
}
