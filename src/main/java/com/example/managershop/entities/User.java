package com.example.managershop.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Builder
@Data @NoArgsConstructor @AllArgsConstructor
@DiscriminatorValue("USER")
public class User extends Personne {
    private String password;
    @Transient  // Ignore cet attribut dans la BD
    private String passwordConfirmed;
    private boolean activated;
    private String photo;
    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
    private Collection<Role> roles= new ArrayList<>();


}
