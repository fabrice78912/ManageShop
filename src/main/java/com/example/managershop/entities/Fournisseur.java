package com.example.managershop.entities;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
@Entity
@Builder
@Data @AllArgsConstructor @NoArgsConstructor
public class Fournisseur {
    @Id
    private String idFsseur;
    private String nameFsseur;
    private String phoneFsseur;
    private String addresseFsseur;
    private String emailFsseur;
    private String villeFsseur;
    private String paysFsseur;
    @ManyToMany(fetch = FetchType.EAGER)
    //@Fetch(value = FetchMode.SUBSELECT)
    private Collection<Produit> produits= new ArrayList<>();
}
