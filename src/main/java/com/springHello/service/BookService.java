package com.springHello.service;

import com.springHello.bean.Book;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

/**
 * Created by root on 1/27/17.
 */
public interface BookService {
    Book findBookById(Long id);
    List<Book> findAllBooks();
    void insertBook(Book book);
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    void deleteBook(Long id);
    Book findBookByName(String name);
}
