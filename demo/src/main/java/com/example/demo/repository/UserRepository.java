package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;



@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    
    User findById(long id);
    Optional<User> findByUsername(String username);
}
