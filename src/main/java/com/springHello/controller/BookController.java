package com.springHello.controller;

import com.springHello.bean.Book;
import com.springHello.exception.BookNotFoundException;
import com.springHello.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Created by mar1 on 2/14/17.
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

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
    public String deleteBook(@PathVariable("id") long id,Model model) throws BookNotFoundException {
        if(bookService.findBookById(id) != null)
            bookService.deleteBook(id);
        else
            throw new BookNotFoundException("Book doesn't exist");
        //return new book list after deleting action
        List<Book> books = bookService.findAllBooks();
        model.addAttribute("books",books);
        return "templates/booksListTemp :: bookList";
    }

    //TODO: edit book
    /*
    @PostMapping("/book/edit/{id}")
    public String editBook(@ModelAttribute Book book, Model model){
        return "templates/bookListTemp ::  bookList";
    }
    */
}
