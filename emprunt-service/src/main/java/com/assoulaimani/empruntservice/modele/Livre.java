package com.assoulaimani.empruntservice.modele;


import lombok.*;


@AllArgsConstructor @NoArgsConstructor @Getter
@Setter
@ToString
@Builder

public class Livre {

    private Long idLivre;

    private String titreLivre;
    private Integer anneeLivre;
    private String editionLivre;
    private String auteurLivre;

}