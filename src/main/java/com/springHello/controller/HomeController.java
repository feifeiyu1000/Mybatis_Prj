package com.springHello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by root on 1/22/17.
 */
@Controller
public class HomeController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String getHome(){
        return "index";
    }

    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public String getHome1(){
        return "index";
    }


}
