package com.assoulaimani.empruntservice.repositories;


import com.assoulaimani.empruntservice.entities.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {
}