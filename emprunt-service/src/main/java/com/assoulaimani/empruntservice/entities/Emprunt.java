package com.assoulaimani.empruntservice.entities;


import com.assoulaimani.empruntservice.modele.User;
import com.assoulaimani.empruntservice.modele.Livre;
import com.assoulaimani.empruntservice.modele.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Emprunt
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmprunt;
    private  Long idUser;
    @Transient
    private User user;
    private Long idLivre;
    @Transient
    private Livre livre;
    private LocalDate dateEmprunt;
    private  LocalDate dateRetour;
}