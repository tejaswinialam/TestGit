package org.kp.msm.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.kp.msm.exception.*;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(LoginFailException.class)
    public String redirectToLogin(){
        return "redirect:/Login";
    }

}
