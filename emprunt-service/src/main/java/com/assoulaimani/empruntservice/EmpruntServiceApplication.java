package com.assoulaimani.empruntservice;


import com.assoulaimani.empruntservice.entities.Emprunt;
import com.assoulaimani.empruntservice.repositories.EmpruntRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication

@EnableDiscoveryClient
@EnableFeignClients



public class EmpruntServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmpruntServiceApplication.class, args);
    }

    @Bean

    public CommandLineRunner commandLineRunner(EmpruntRepository empruntRepository) {
        return args -> {
            Emprunt emprunt1 = Emprunt.builder()
                    .idLivre(Long.valueOf("1"))
                    .idUser(Long.valueOf("1"))
                    .dateRetour(LocalDate.of(2026, 1, 1))
                    .dateEmprunt(LocalDate.of(2026, 2, 1))
                    .build();
            empruntRepository.save(emprunt1);

            Emprunt emprunt2 = Emprunt.builder()
                    .idLivre(Long.valueOf("2"))
                    .idUser(Long.valueOf("1"))
                    .dateRetour(LocalDate.of(2026, 1, 1))
                    .dateEmprunt(LocalDate.of(2026, 2, 1))
                    .build();
            empruntRepository.save(emprunt2);

            Emprunt emprunt3 = Emprunt.builder()
                    .idLivre(Long.valueOf("2"))
                    .idUser(Long.valueOf("2"))
                    .dateRetour(LocalDate.of(2026, 2, 1))
                    .dateEmprunt(LocalDate.of(2026, 3, 1))
                    .build();
            empruntRepository.save(emprunt3);
            List<Emprunt> emprunts = empruntRepository.findAll();

            for (Emprunt emprunt : emprunts) {
                System.out.println(emprunt.toString());

            }

        };

    }
}