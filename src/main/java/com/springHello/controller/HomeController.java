package com.springHello.controller;

import com.springHello.bean.Book;
import com.springHello.exception.BookNotFoundException;
import com.springHello.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by root on 1/22/17.
 */
@Controller
public class HomeController {

    @Autowired
    private BookService bookService;



    @GetMapping({"/home","/"})
    public String getHome() {
        return "index";
    }



    @GetMapping("/books")
    public String getBooks(Model model){
        List<Book> books = bookService.findAllBooks();
        model.addAttribute("books",books);
        return "booksList";
    }

    @GetMapping("/book/{id}")
    public String getBook(@PathVariable("id") long id, Model model) throws BookNotFoundException {
        Book book = bookService.findBookById(id);
        if(book == null || book.getId() <= 0) throw new BookNotFoundException("Book doesn't exist");

        model.addAttribute(book);
        return "book";
    }

    @GetMapping("/book/delete/{id}")
    public String deleteBook(@PathVariable("id") long id) throws BookNotFoundException {
        if(bookService.findBookById(id) != null)
            bookService.deleteBook(id);
        else
            throw new BookNotFoundException("Book doesn't exist");
        return "redirect:/books";
    }

    @GetMapping(path = "/error")
    public String getError(){
        return "errorPage";
    }



}
