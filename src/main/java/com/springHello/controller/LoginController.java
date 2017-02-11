package com.springHello.controller;

import com.springHello.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by mar1 on 2/10/17.
 */
@Controller
public class LoginController {

    private final static String LOGIN_VIEW = "login";

    @GetMapping("/login")
    public String getLogin(Model model){

        model.addAttribute("user",new User());
        return LOGIN_VIEW;
    }

    @PostMapping("/login")
    public String RootForm(){
        return "redirect:/";
    }
    /*
    @GetMapping("/logout")
    public String getLogout(HttpServletResponse response){
        Cookie cookie = new Cookie("JSESSIONID", null); // Not necessary, but saves bandwidth.
        cookie.setHttpOnly(true);
        cookie.setMaxAge(0); // Don't set to -1 or it will become a session cookie!
        response.addCookie(cookie);
        return "redirect:/";
    }
    */

}
