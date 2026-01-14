package com.assoulaimani.userservice.web;


import com.assoulaimani.userservice.entities.User;
import com.assoulaimani.userservice.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    UserRepository UserRepository;
    public Controller(UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    @GetMapping("/users")
    public List<User> findAll(){
        return UserRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public User findById(@PathVariable Long id){
        return UserRepository.findById(id).get();
    }

}