package com.assoulaimani.empruntservice.web;

import com.assoulaimani.empruntservice.modele.User;
import com.assoulaimani.empruntservice.modele.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="USER-SERVICE")

public interface UserFeign {

    @GetMapping("/users")
    List<User> getUsers();

    @GetMapping("/users/{id}")
    User getUser(@PathVariable Long id);

}