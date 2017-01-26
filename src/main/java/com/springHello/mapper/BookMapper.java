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

    /*
    @Select("SELECT id,name,nbrPage,creationDate FROM BOOK")
    @Results({
            @Result(id=true, property = "id", column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "nbrPage",column = "nbrPage"),
            @Result(property = "creationDate",column = "creationDate")
    })
    */
    List<Book> findAllBooks();

    Collection<Book> findAllBooksV2();

    Book findBookById(Long id);
}
