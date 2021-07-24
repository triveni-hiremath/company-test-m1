package com.company.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class CompanyControllerAdvice {

    private static final Map<String, String> ERROR_MSG_MAP = new HashMap<String,String>() {{
        put("message", "Something went wrong");
    }};

    private static final Map<String, Map> ERROR_MAP = new HashMap<String,Map>() {{
        put("error", ERROR_MSG_MAP);
    }};

    @ExceptionHandler(CompanyNotFoundException.class)
    public ResponseEntity getCustomerNotFoundExceptionResponse() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity getExceptionResponse() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ERROR_MAP);
    }
}
