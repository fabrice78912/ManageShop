package com.example.managershop.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Builder
@Data @NoArgsConstructor @AllArgsConstructor
public class Remise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRemise;
    private String nameRemise;
    private float tauxRemise;
    @OneToMany(mappedBy = "remise") // ie dans la table produit la cle etrangere sera id de la Remise
    @JsonIgnore
    private Collection<Produit> produits;
}
