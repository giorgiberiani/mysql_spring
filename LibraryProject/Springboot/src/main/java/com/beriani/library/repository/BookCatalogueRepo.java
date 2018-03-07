package com.beriani.library.repository;

import com.beriani.library.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCatalogueRepo extends CrudRepository<Book,Integer> {

}
