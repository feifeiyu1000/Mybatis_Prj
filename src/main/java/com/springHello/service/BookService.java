package com.springHello.service;

import com.springHello.bean.Book;
import com.springHello.mapper.BookMapper;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * Created by root on 1/26/17.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class BookService implements BookMapper {

    private Logger logger = Logger.getLogger(getClass());

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> findAllBooks() {
        logger.debug("Find All Books ==> : {}");
        System.out.println("Find All Boos");
        return bookMapper.findAllBooks();
    }

    @Override
    public Collection<Book> findAllBooksV2() {
        return bookMapper.findAllBooksV2();
    }

    @Override
    public Book findBookById(Long id) {
        return bookMapper.findBookById(id);
    }
}
