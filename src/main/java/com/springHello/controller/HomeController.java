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


    @RequestMapping(path = {"/home"}, method = RequestMethod.GET)
    public String getHome() {
        return "index";
    }

    @RequestMapping(path = {"/"}, method = RequestMethod.GET)
    public String getIndex(){
        return "index";
    }


    @RequestMapping("/books")
    public String getBooks(Model model){
        List<Book> books = bookService.findAllBooks();
        model.addAttribute("books",books);
        return "booksList";
    }

    @RequestMapping("/book/{id}")
    public String getBook(@PathVariable("id") long id, Model model) throws BookNotFoundException {
        Book book = bookService.findBookById(id);
        if(book == null || book.getId() <= 0) throw new BookNotFoundException("Book doesn't exist");

        model.addAttribute(book);
        return "book";
    }

    @RequestMapping(path = "/error", method = RequestMethod.GET)
    public String getError(){
        return "errorPage";
    }



}
