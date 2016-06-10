package com.johnathanmsmith.mvc.web.controller;

import com.johnathanmsmith.mvc.web.model.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @Autowired
    Car carList;

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String MainIndex(){
        logger.debug("made it to controller");
        return "index";
    }

    @RequestMapping(value="/AddToCarList", method = RequestMethod.POST)
    public ModelAndView AddList(HttpServletRequest request) {
        ModelAndView MAVadd = new ModelAndView("list");
        carList.addNewCar(request.getParameter("addNewCar"));
        MAVadd.addObject("CarList", carList.getListTable());
        MAVadd.setViewName("list");

        logger.debug("made it to controller");
        return MAVadd;
    }

    @RequestMapping(value="/RemoveToCarList", method = RequestMethod.POST)
    public ModelAndView RemoveList(HttpServletRequest request) {
        ModelAndView MAVremove = new ModelAndView("list");
        carList.removeCar(Integer.valueOf(request.getParameter("deleteCar")) - 1);
        MAVremove.addObject("CarList", carList.getListTable());
        MAVremove.setViewName("list");

        logger.debug("made it to controller");
        return MAVremove;
    }


    @RequestMapping(value="/EditToCarList", method = RequestMethod.POST)
    public ModelAndView EditList(HttpServletRequest request) {
        ModelAndView MAVedit = new ModelAndView("list");
        carList.editCar(Integer.valueOf(request.getParameter("idEditCar")) - 1, request.getParameter("editCar"));
        MAVedit.addObject("CarList", carList.getListTable());
        MAVedit.setViewName("list");

        logger.debug("made it to controller");
        return MAVedit;
    }



}