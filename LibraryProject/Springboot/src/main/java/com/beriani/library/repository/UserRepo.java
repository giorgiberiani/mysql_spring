package com.beriani.library.repository;

import com.beriani.library.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User,Integer> {

   User findByUsername (String username);
}
