package com.ms.user.exception;

import com.ms.user.configs.ExceptionConfigs;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@ControllerAdvice
@AllArgsConstructor
public class HandleException {

    private final ExceptionConfigs exceptionConfigs;

  /*  @Value("${control.exception}")
    private String businessException;*/

    @ExceptionHandler(MyHandleException.class)
    public ResponseEntity<Object> handleMyException(MyHandleException ex){
        log.error(
                exceptionConfigs.getTypeException(ExceptionConfigs.BUSINESS)+ " error info  \n {}",ex.getMessage()
        );
        return ResponseEntity
                .badRequest()
                .body(String.format(
                        """
                                %s : %s
                                """,exceptionConfigs.getTypeException(ExceptionConfigs.BUSINESS),ex.getMessage()
                ));
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex){
        return ResponseEntity
                .badRequest()
                .body(String.format(
                        """
                                %s : %s
                                """,exceptionConfigs.getTypeException(ExceptionConfigs.SYSTEM),ex.getMessage()
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
