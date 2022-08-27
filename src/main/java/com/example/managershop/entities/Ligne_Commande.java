package com.example.managershop.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Data @AllArgsConstructor @NoArgsConstructor
public class Ligne_Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idLigneCde;
    private double qteCde;
    private double prixCde;
    @ManyToOne
    private Commande commande;
    @ManyToOne
    private Produit produit;
}
