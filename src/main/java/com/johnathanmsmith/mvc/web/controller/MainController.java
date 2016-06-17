package com.johnathanmsmith.mvc.web.controller;

import com.johnathanmsmith.mvc.web.model.CarDto;
import com.johnathanmsmith.mvc.web.model.Car;
import com.johnathanmsmith.mvc.web.model.CarDtoFactory;
import com.johnathanmsmith.mvc.web.model.CarList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MainController {

    @Autowired
     CarList ct;

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = CarRestURIConstants.INDEX, method = RequestMethod.GET)
    public String MainIndex()
    {
        logger.debug("INDEX controller");
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = CarRestURIConstants.LIST, method = RequestMethod.GET)
    public ModelAndView List()
    {
        logger.debug("LIST controller");
        return new ModelAndView("list");
    }

    @ResponseBody
    @RequestMapping(value = CarRestURIConstants.SHOWLIST, method = RequestMethod.GET, produces = "application/json")
    public List<Car> Show()
    {
        logger.debug("SHOW controller");
        return ct.getCarListTable();
    }

    @ResponseBody
    @RequestMapping(value = CarRestURIConstants.ADD_CAR, method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public Car add(@Valid @RequestBody CarDto carDto, BindingResult result)
    {
        CarDtoFactory carDtoFactory = new CarDtoFactory();
        if (!result.hasErrors()) {
            logger.debug("ADD controller");
            return carDtoFactory.SerializerCar(carDto, ct);
        }
        logger.debug("ERROR ADD controller");
        return carDtoFactory.Error();
    }

/*    @ResponseBody
    @RequestMapping(value = CarRestURIConstants.ADD_CAR, method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public Car add(@RequestBody CarDto carDto)
    {
        CarDtoFactory carDtoFactory = new CarDtoFactory();
        logger.debug("ADD controller");
        return carDtoFactory.SerializerCar(carDto, ct);
    }*/

    @ResponseBody
    @RequestMapping(value = CarRestURIConstants.DELETE_CAR, method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public Boolean delete(@RequestBody Car car)
    {
        logger.debug("Delete controller");
        return ct.deleteCar(car.getId());
    }

    @ResponseBody
    @RequestMapping(value = CarRestURIConstants.EDIT_CAR, method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public Car edit(@RequestBody Car car)
    {
        logger.debug("Delete controller");
        return ct.editCar(car);
    }

}