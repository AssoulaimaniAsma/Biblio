package com.assoulaimani.livreservice;

import com.assoulaimani.livreservice.Config.ConfigGlobal;

import com.assoulaimani.livreservice.Config.ConfigLocal;

import com.assoulaimani.livreservice.entities.Livre;
import com.assoulaimani.livreservice.repositories.LivreRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient

@EnableConfigurationProperties({ConfigGlobal.class, ConfigLocal.class})

public class LivreServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LivreServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner init(LivreRepository livreRepository) {
        return args -> {
            Livre l1= Livre.builder()
                    .auteurLivre("Logan")
                    .titreLivre("Réseaux")
                    .editionLivre("Eyrolles")
                    .anneeLivre(2025)
                    .build();

            livreRepository.save(l1);

            Livre l2=Livre.builder()
                    .auteurLivre("Tanabaum")
                    .titreLivre("IA")
                    .anneeLivre(2024)
                    .editionLivre("spring")
                    .build();
            livreRepository.save(l2);

            Livre l3=Livre.builder()
                    .auteurLivre("Bourget")
                    .titreLivre(".Net ")
                    .anneeLivre(2024)
                    .editionLivre("Verlag")
                    .build();
            livreRepository.save(l3);

            List<Livre> liste=livreRepository.findAll();

            for ( Livre l : liste ) {
                System.out.println(l.getAuteurLivre());
                System.out.println(l.getTitreLivre());
                System.out.println(l.getEditionLivre());
            }


        };
    }

}