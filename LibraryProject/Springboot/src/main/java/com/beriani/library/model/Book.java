package com.beriani.library.model;

import javax.persistence.*;

@Entity(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookID;

    private String author;
    private String name;
    private int year;
    private int isbn;

    public Book(){}



    public void setAuthor(String author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }



    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getIsbn() {
        return isbn;
    }
}
