package com.springHello.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


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
    public String getHome(Principal principal,Model model) {

        model.addAttribute("principalName",principal.getName());
        System.out.println("================================================>>>>>>>>>>>>>>"+principal.toString());
        return "index";
    }*/





    /*
    @GetMapping(path = "/error")
    public String getError(){
        return "errorPage";
    }
    */


}
