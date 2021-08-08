package com.test.hplus.exception;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
//Global handling exception(Even if Controller Class has own controller only that controller handling done first)
@ControllerAdvice
public class ApplicationExceptionHandler {
    @ExceptionHandler(ApplicationException.class)  /*telling exceptionHandler to handle which class*/
    public String handleException(){
        System.out.println("in global  exception handler of login Controller");
        return "error";  //Show ViewName
    }



}
