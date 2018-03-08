package com.beriani.library.controller;

import com.beriani.library.model.Book;
import com.beriani.library.model.User;
import com.beriani.library.model.UserLogin;
import com.beriani.library.repository.BookCatalogueRepo;
import com.beriani.library.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Transactional
@CrossOrigin(origins = "http://localhost:4200.", maxAge = 3600)
@Order(Ordered.HIGHEST_PRECEDENCE)
@RestController
@RequestMapping("/api")
public class UserControler {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private  BookCatalogueRepo bookCatalogueRepo;

    @Autowired
    private HttpSession httpSession;



    @RequestMapping(method = RequestMethod.POST, value="/check")
    public ResponseEntity<UserLogin> checkUser(@RequestBody UserLogin userLogin){

        User user = userRepo.findByUsername(userLogin.getUsername());

        if(user != null){
            if(user.getPassword().equals(userLogin.getPassword())){
                httpSession.setAttribute("user",user);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }





    @RequestMapping(method = RequestMethod.GET,value = "/getfavorite")
    public List<Book> getFavoriteBook(Book book){

        User user = (User) this.httpSession.getAttribute("user");
        return new ArrayList<>( this.userRepo.findByUsername(user.getUsername()).getBooks());


    }

    @RequestMapping(method = RequestMethod.POST, value = "/addfavorite")
    public void addFavorite(@RequestBody Book book){

        User tmp = (User) this.httpSession.getAttribute("user");
        User user = this.userRepo.findByUsername(tmp.getUsername());
        if(!user.getBooks().contains(book)) {
            user.getBooks().add(book);
            this.userRepo.save(user);
        }

    }

    @Transactional
    @RequestMapping(method = RequestMethod.POST,value = "/deletefavorite")
    public void deleteFavorite(@RequestBody Book book){
        User tmp = (User) this.httpSession.getAttribute("user");
        User user = this.userRepo.findByUsername(tmp.getUsername());
        Iterator<Book> userIterator = user.getBooks().iterator();
        while(userIterator.hasNext()){
            Book deleteBook = userIterator.next();
            if(deleteBook.getBookID() == book.getBookID()){
                userIterator.remove();
                break;
            }
        }
        this.userRepo.save(user);
    }




    @RequestMapping(method = RequestMethod.GET,value = "/home")
    public List<Book> getAllBooks(){


        return (List<Book>) bookCatalogueRepo.findAll();

    }




}
