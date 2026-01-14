package com.assoulaimani.empruntservice.modele;




import lombok.*;

@Getter @Setter
@ToString @NoArgsConstructor @AllArgsConstructor
@Builder


public class User {
    private Long idUser;
    private String firstName;
    private String lastName;
    private String email;
}
