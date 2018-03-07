package com.beriani.library.controller;

import com.beriani.library.model.Book;
import com.beriani.library.model.User;
import com.beriani.library.model.UserLogin;
import com.beriani.library.repository.BookCatalogueRepo;
import com.beriani.library.repository.FavoriteBooks;
import com.beriani.library.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

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



    @RequestMapping(method = RequestMethod.POST,value = "/addfavorite")
    public void addFavoriteBook(@RequestBody Book book){



    }

//    @GetMapping(value = "/getFavorites")
//    public List<Book> getFavorite(){
//
//        User user = (User) this.httpSession.getAttribute("user");
//        return new ArrayList<>((this.userRepository.findByEmail(user.getEmail()).getBooks()));
//    }
//
//    @PostMapping(value = "/addFavorite")
//    public void addFavorite(@RequestBody final Book book){
//        User tmp = (User) this.httpSession.getAttribute("user");
//        User user = this.userRepository.findByEmail(tmp.getEmail());
//        user.getBooks().add(book);
//        this.userRepository.save(user);
//    }



    @RequestMapping(method = RequestMethod.GET,value = "/home")
    public List<Book> getAllBooks(){


        return (List<Book>) bookCatalogueRepo.findAll();

    }




}
