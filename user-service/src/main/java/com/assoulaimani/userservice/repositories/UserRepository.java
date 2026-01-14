package com.assoulaimani.userservice.repositories;


import com.assoulaimani.userservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}