package com.example.managershop.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
//@Builder
@Data @NoArgsConstructor @AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_PERSON")
public abstract class Personne implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPerson;
    private String civilitePerson;
    @Column(unique = true)
    @NotNull
    private String namePerson;
    private String lastNamePerson;
    @Email
    private String emailPerson;
    private String villePerson;
    @NotNull
    private String numCniPerson;
    private String photo;

}
