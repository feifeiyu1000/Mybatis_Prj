package com.springHello.mapper;

import com.springHello.bean.Book;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.Collection;
import java.util.List;

/**
 * Created by root on 1/26/17.
 */
public interface BookMapper {

    Book findBookById(Long id);
    List<Book> findAllBooks();
    void insertBook(Book book);
    void deleteBook(Long id);
    Book findBookByName(String name);
}
