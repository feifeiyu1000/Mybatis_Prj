package com.springHello.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by root on 1/26/17.
 */
public class Book implements Serializable {

    private Long id;
    private String name;
    private int nbrPage;
    private Date creationDate;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNbrPage() {
        return nbrPage;
    }

    public void setNbrPage(int nbrPage) {
        this.nbrPage = nbrPage;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nbrPage=" + nbrPage +
                ", creationDate=" + creationDate +
                '}';
    }
}
