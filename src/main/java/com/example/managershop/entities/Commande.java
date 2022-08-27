package com.example.managershop.entities;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Builder
@Data @NoArgsConstructor @AllArgsConstructor
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCde;
    private TypePaiement modepaiement;
    private LocalDate dateCde;
    private double MontantTotalCde;
    @ManyToOne
    private Client client;
    @OneToMany(mappedBy = "commande", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private Collection<Ligne_Commande> ligne_commandes= new ArrayList<>();

}
