package com.assoulaimani.livreservice.repositories;

import com.assoulaimani.livreservice.entities.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivreRepository  extends JpaRepository<Livre, Long> {
}