package com.ms.user.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class HandleException {


    @ExceptionHandler(MyHandleException.class)
    public ResponseEntity<Object> handleMyException(MyHandleException ex){
        return ResponseEntity
                .badRequest()
                .body(String.format(
                        """
                                Business exception : %s
                                """,ex.getMessage()
                ));
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex){
        return ResponseEntity
                .badRequest()
                .body(String.format(
                        """
                                System exception : %s
                                """,ex.getMessage()
                ));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentException(MethodArgumentNotValidException ex){

        List<String> errorList =new ArrayList<>();

        for(FieldError error : ex.getBindingResult().getFieldErrors()){
            errorList.add(error.getObjectName() + " : " +  error.getField() + " : " + error.getDefaultMessage());
        }
        return ResponseEntity
                .badRequest()
                .body(errorList);
    }



}
