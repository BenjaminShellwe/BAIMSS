package com.inter.baimss.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EntityExceptionAdvice {

    @ExceptionHandler
    public R monitorException(Exception e) {
        e.printStackTrace();
        return new R(false, "There was an error!");
    }
}
