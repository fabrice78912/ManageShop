package com.example.managershop.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Builder
@Data  @AllArgsConstructor @NoArgsConstructor
public class ProduitPromo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPdtpromo;
    private double soldeprome;
    private LocalDate dateDebutpromo;
    private LocalDate dateFinpromo;
    @OneToOne
    private Produit produit;
}
