package com.springHello.controller;

import com.springHello.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
}
