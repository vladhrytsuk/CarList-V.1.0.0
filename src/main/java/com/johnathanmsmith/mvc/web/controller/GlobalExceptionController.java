package com.johnathanmsmith.mvc.web.controller;

import com.johnathanmsmith.mvc.web.config.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorDTO handleValidateException(MethodArgumentNotValidException error)
    {
        ErrorDTO errorDTO = new ErrorDTO(error.getMessage());
        errorDTO.ExceptionHandler();
        return errorDTO;
    }

/*    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllException(Exception ex) {

        ModelAndView model = new ModelAndView("list");
        model.addObject("errMsg", "this is Exception.class");

        return model;

    }*/

}
