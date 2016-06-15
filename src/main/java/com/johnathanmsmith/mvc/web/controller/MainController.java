package com.johnathanmsmith.mvc.web.controller;

import com.johnathanmsmith.mvc.web.model.CarDto;
import com.johnathanmsmith.mvc.web.model.Car;
import com.johnathanmsmith.mvc.web.model.CarDtoFactory;
import com.johnathanmsmith.mvc.web.model.CarList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @Autowired
     CarList ct;

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = CarRestURIConstants.INDEX, method = RequestMethod.GET)
    public String MainIndex(){
        logger.debug("INDEX controller");
        return "index";
    }

    @RequestMapping(value = CarRestURIConstants.LIST, method = RequestMethod.GET)
    public @ResponseBody ModelAndView List(ModelMap model){
        model.put("ct",ct);
        logger.debug("LIST controller");
        return new ModelAndView("list");
    }

    @ResponseBody
    @RequestMapping(value = CarRestURIConstants.ADD_CAR, method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public Car addCar(@RequestBody CarDto carDto){
        ModelAndView add = new ModelAndView("list");
        CarDtoFactory carDtoFactory = new CarDtoFactory();
        ct.addCar(carDtoFactory.SerializerCar(carDto));
        add.addObject("ct", ct);
        logger.debug("ADD controller");
        return carDtoFactory.SerializerCar(carDto);
    }

}