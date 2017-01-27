package com.springHello.service;

import com.springHello.bean.Book;

import java.util.List;

/**
 * Created by root on 1/27/17.
 */
public interface BookService {
    Book findBookById(Long id);
    List<Book> findAllBooks();
    void insertBook(Book book);
    void deleteBook(Long id);
    Book findBookByName(String name);
}
