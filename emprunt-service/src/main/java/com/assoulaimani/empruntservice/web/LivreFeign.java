package com.assoulaimani.empruntservice.web;



import com.assoulaimani.empruntservice.modele.Livre;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="LIVRE-SERVICE")

public interface LivreFeign {

    @GetMapping("/livres")
    List<Livre> getLivres();

    @GetMapping("/livres/{id}")
    Livre getLivre(@PathVariable("id") Long id);

}