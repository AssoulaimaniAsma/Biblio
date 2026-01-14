package com.assoulaimani.livreservice.web;

import com.assoulaimani.livreservice.Config.ConfigGlobal;
import com.assoulaimani.livreservice.Config.ConfigLocal;

import com.assoulaimani.livreservice.entities.Livre;
import com.assoulaimani.livreservice.repositories.LivreRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LivreController {

    public LivreController(LivreRepository livreRepository, ConfigGlobal configGlobal, ConfigLocal configLocal) {
        this.livreRepository = livreRepository;
        this.configGlobal = configGlobal;
        this.configLocal = configLocal;
    }

    LivreRepository livreRepository;
    ConfigGlobal configGlobal;

    ConfigLocal configLocal;
   @GetMapping("/livres")
    public List<Livre> getLivres() {
        return livreRepository.findAll();
    }

    @GetMapping("/livres/{id}")
    public Livre getLivre(@PathVariable Long id) {
        return livreRepository.findById(id).get();

    }

    @GetMapping("/livres/configGlobal")
    public ConfigGlobal getConfigGlobal() {
        return configGlobal;

    }

    @GetMapping("/livres/configLocal")
    public ConfigLocal  getConfigLocal() {
        return configLocal;

    }

}