package com.beriani.library.repository;

import com.beriani.library.model.BookCatalogue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCatalogueRepo extends CrudRepository<BookCatalogue,Integer> {

}
