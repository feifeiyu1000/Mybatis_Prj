package com.springHello.web.controller;

import com.springHello.bean.Book;
import com.springHello.bean.User;
import com.springHello.exception.BookNotFoundException;
import com.springHello.service.BookService;
import com.springHello.utils.DateFormate;
import com.springHello.web.validator.BookValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by mar1 on 2/14/17.
 */
@Controller
public class BookController {

    private static final String REDIRECT_TO_BOOKS_PAGE = "redirect:/books";
    private static final String BOOKS_PAGE = "/booksList";
    private static final String BOOK_PAGE = "/book";
    private static final String CREATE_BOOK_PAGE = "/createBook";
    private static final String URL_CREATE_BOOK_PAGE = "/book/create";

    @Autowired
    private BookService bookService;

    @Autowired
    private BookValidator bookValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(bookValidator);
    }

    @GetMapping("/books")
    public String getBooks(Model model){
        List<Book> books = bookService.findAllBooks();
        model.addAttribute("books",books);
        return BOOKS_PAGE;
    }

    @GetMapping("/book/{id}")
    public String getBook(@PathVariable("id") long id, Model model) throws BookNotFoundException {
        Book book = bookService.findBookById(id);
        if(book == null || book.getId() <= 0) throw new BookNotFoundException("Book doesn't exist");

        model.addAttribute(book);
        return BOOK_PAGE;
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

    @PostMapping(URL_CREATE_BOOK_PAGE)
    public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            //faild validation
            return CREATE_BOOK_PAGE;
        try{
            System.out.println(book);
            bookService.insertBook(book);
        }catch(DataIntegrityViolationException e){
            // probably Book already exists - very rare case when multiple users are adding same book
            // at the same time and form validation has passed for more than one of them.

            bindingResult.reject("book.exists", "Book already exists");
            return CREATE_BOOK_PAGE;
        }
        return REDIRECT_TO_BOOKS_PAGE;
    }

    @GetMapping(URL_CREATE_BOOK_PAGE)
    public String getBookCreationPage(Model model){
        model.addAttribute("book",new Book());
        return CREATE_BOOK_PAGE;
    }


    //TODO: edit book
    /*
    @PostMapping("/book/edit/{id}")
    public String editBook(@ModelAttribute Book book, Model model){
        return "templates/bookListTemp ::  bookList";
    }
    */
}
