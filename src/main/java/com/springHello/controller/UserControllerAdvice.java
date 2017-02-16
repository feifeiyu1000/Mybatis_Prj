package com.springHello.controller;

import com.springHello.bean.User;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by mar1 on 2/16/17.
 */
@ControllerAdvice
public class UserControllerAdvice {

    @ModelAttribute("currentUser")
    public User getCurrentUser(Authentication authentication){
        return (authentication == null) ? null : (User) authentication.getPrincipal();
    }
}
