package com.springHello.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * Created by root on 1/22/17.
 */
@Controller
public class HomeController {


    @GetMapping({"/home","/"})
    public String getHome() {
        return "index";
    }





    /*
    @GetMapping(path = "/error")
    public String getError(){
        return "errorPage";
    }
    */


}
