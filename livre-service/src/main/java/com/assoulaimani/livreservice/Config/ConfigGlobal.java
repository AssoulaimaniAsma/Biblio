package com.assoulaimani.livreservice.Config;


import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter

@AllArgsConstructor @NoArgsConstructor @ToString
@Builder

// Chercher les paramètres globaux
// On ajoute aussi @EnableConfigurationProperties({ConfigGlobal.class
// Dans l'application principale
@ConfigurationProperties( prefix = "global.params")
public class ConfigGlobal {
    int g1;
    int g2;
}