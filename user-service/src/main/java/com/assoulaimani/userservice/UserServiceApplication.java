package com.assoulaimani.userservice;


import com.assoulaimani.userservice.entities.User;
import com.assoulaimani.userservice.repositories.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient

public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }


    @Bean
    public CommandLineRunner init(UserRepository userRepository) {
        return args -> {

            User u1= User.builder()
                    .lastName("assoulaimani")
                    .firstName("asma")
                    .email("assoulaimani@gmail.com")
                    .build();
            userRepository.save(u1);

            User u2 = User.builder()
                    .lastName("elamari")
                    .firstName("latifa")
                    .email("elamari@gmail.com")
                    .build();
            userRepository.save(u2);

            User u3 = User.builder()
                    .lastName("majdoule")
                    .firstName("manal")
                    .email("manal@gmail.com")
                    .build();
            userRepository.save(u3);

        };
    }

}