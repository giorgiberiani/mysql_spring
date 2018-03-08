package com.beriani.library.model;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userID;

    private String name;
    private String lname;
    private String username;
    private String password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_book",
            joinColumns = @JoinColumn(name = "userID"),
            inverseJoinColumns = @JoinColumn(name = "bookID")
    )
    private Set<Book> books;

    public Set<Book> getBooks(){
        return books;
    }

    public void setBooks(Set<Book> books){
        this.books = books;
    }



    public User() {
    }


    public Integer getUserID() {
        return userID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public String getLname() {
        return lname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

