package com.springHello.controller;

import com.springHello.bean.Book;
import com.springHello.exception.BookNotFoundException;
import com.springHello.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by root on 1/22/17.
 */
@Controller
public class HomeController {

    @Autowired
    private BookService bookService;

<<<<<<< HEAD
    @RequestMapping(path = {"/"}, method = RequestMethod.GET)
=======
    @RequestMapping(path = {"/home"}, method = RequestMethod.GET)
>>>>>>> configException
    public String getHome() throws Exception {
        if(true) throw new Exception();
        return "index";
    }

<<<<<<< HEAD
    @RequestMapping(path = {"/home"}, method = RequestMethod.GET)
=======
    @RequestMapping(path = {"/"}, method = RequestMethod.GET)
>>>>>>> configException
    public String getIndex() {
        return "index";
    }


    @RequestMapping("/books")
    public String getBooks(Model model){
        List<Book> books = bookService.findAllBooks();
        model.addAttribute("books",books);
        return "books";
    }

    @RequestMapping("/book/{id}")
    public String getBook(@PathVariable("id") long id, Model model){
        Book book = bookService.findBookById(id);
        if(true) throw new BookNotFoundException();

        model.addAttribute(book);
        return "book";
    }

    @RequestMapping(path = "/error", method = RequestMethod.GET)
    public String getError(){
        return "errorPage";
    }



}
