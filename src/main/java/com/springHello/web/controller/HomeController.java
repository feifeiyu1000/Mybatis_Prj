package com.springHello.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * Created by root on 1/22/17.
 * @author mar1
 *
 */
@Controller
public class HomeController {

    public static final String HOME_PAGE = "index";
    public static final String FIRST_URL_TO_HOME_PAGE = "/home";
    public static final String SECOND_URL_TO_HOME_PAGE = "/";

    /**
     *
     * @return template name for home page "index"
     */
    @GetMapping({FIRST_URL_TO_HOME_PAGE,SECOND_URL_TO_HOME_PAGE})
    public String getHome() {
        return HOME_PAGE;
    }
}
