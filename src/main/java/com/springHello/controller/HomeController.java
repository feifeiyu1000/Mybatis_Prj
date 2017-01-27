package com.springHello.controller;

import com.springHello.bean.Book;
import com.springHello.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by root on 1/22/17.
 */
@Controller
public class HomeController {

    @Autowired
    private BookService bookService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String getHome(){
        return "index";
    }

    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public String getHome1(){
        return "index";
    }

    @RequestMapping("/books")
    public String getBooks(Model model){
        List<Book> books = bookService.findAllBooks();
        model.addAttribute("books",books);
        return "books";
    }


}
