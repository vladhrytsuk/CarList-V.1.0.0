package com.johnathanmsmith.mvc.web.controller;

import com.johnathanmsmith.mvc.web.config.ErrorDTO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.ConstraintViolation;

@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleCustomException(Exception ex) {
        ModelAndView model = new ModelAndView();
        model.addObject("errMsg", ex.getMessage());
/*        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setErrorMsg(ex.getMessage());
        return errorDTO;*/
        return model;
    }

/*    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllException(Exception ex) {

        ModelAndView model = new ModelAndView("list");
        model.addObject("errMsg", "this is Exception.class");

        return model;

    }*/

}
