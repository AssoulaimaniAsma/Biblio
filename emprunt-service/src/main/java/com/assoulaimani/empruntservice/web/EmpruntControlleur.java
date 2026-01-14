package com.assoulaimani.empruntservice.web;


import com.assoulaimani.empruntservice.entities.Emprunt;
import com.assoulaimani.empruntservice.modele.User;
import com.assoulaimani.empruntservice.modele.Livre;

import com.assoulaimani.empruntservice.repositories.EmpruntRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class EmpruntControlleur {

    final private LivreFeign  livreFeign;
    final  private UserFeign userFeign;

    public EmpruntControlleur(LivreFeign livreFeign, UserFeign userFeign, EmpruntRepository empruntRepository) {
        this.livreFeign = livreFeign;
        this.userFeign = userFeign;
        this.empruntRepository = empruntRepository;
    }

    final EmpruntRepository empruntRepository;




    @GetMapping("/emprunts")
    public List<Emprunt> getEmprunts () {
        List<Livre> livres = livreFeign.getLivres();


        List<User>  users = userFeign.getUsers();
        List<Emprunt> emprunts = empruntRepository.findAll();

        //List<Emprunt> liste=new ArrayList<>();

        for (Emprunt em : emprunts) {

            for (User e : users)
                if  (e.getIdUser()==em.getIdUser())
                {em.setUser(e);
                    break;}

            for (Livre l : livres)
                if (em.getIdLivre()== l.getIdLivre())
                { em.setLivre(l);
                    break;}

        }


        return emprunts;

    }

    @GetMapping("/emprunts/{id}")
    public Emprunt getEmprunt (@PathVariable("id") Long id) {

        Emprunt emprunt = empruntRepository.findById(id).get();

        Livre livre = livreFeign.getLivre(emprunt.getIdLivre());

        User user = userFeign.getUser(emprunt.getIdUser());

        emprunt.setUser(user);
        emprunt.setLivre(livre);

        return emprunt;
    }



}
