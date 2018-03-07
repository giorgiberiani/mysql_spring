package com.beriani.library.repository;

import com.beriani.library.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface FavoriteBooks extends CrudRepository<Book,Integer>{
}
