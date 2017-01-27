package com.springHello.service;

import com.springHello.bean.Book;
import com.springHello.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by root on 1/27/17.
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public Book findBookById(Long id) {
        return bookMapper.findBookById(id);
    }

    @Override
    public List<Book> findAllBooks() {
        return bookMapper.findAllBooks();
    }

    @Override
    public void insertBook(Book book) {
        bookMapper.insertBook(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookMapper.deleteBook(id);
    }

    @Override
    public Book findBookByName(String name) {
        return bookMapper.findBookByName(name);
    }
}
