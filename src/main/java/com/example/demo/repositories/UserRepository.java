package com.example.demo.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
  
    List<User> findByFirstName(String firstName);
    List<User> findByLastName(String lastName);

    // User findById(long id);

}
