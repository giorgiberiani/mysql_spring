package com.beriani.library.controller;

import com.beriani.library.model.BookCatalogue;
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

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200.", maxAge = 3600)
@Order(Ordered.HIGHEST_PRECEDENCE)
@RestController
@RequestMapping("/api")
public class UserControler {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    BookCatalogueRepo bookCatalogueRepo;

    @RequestMapping(method = RequestMethod.POST, value="/check")
    public ResponseEntity<UserLogin> checkUser(@RequestBody UserLogin userLogin){

        System.out.println( userLogin.getPassword()+" "+userLogin.getUsername());

        User user = userRepo.findByUsername(userLogin.getUsername());

        if(user != null){
            if(user.getPassword().equals(userLogin.getPassword())){
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }




    @RequestMapping(method = RequestMethod.GET,value = "/home")
    public List<BookCatalogue> getAllBooks(){

        return (List<BookCatalogue>) bookCatalogueRepo.findAll();
    }



}
