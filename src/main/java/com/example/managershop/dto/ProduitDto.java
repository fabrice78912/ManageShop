package com.example.managershop.dto;

import com.example.managershop.entities.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Data
@AllArgsConstructor @NoArgsConstructor
public class ProduitDto {

    @JsonIgnore
    private String idPdt;
    @NotNull
    private String nomPdt;
    private float prixAchatPdt;
    private float prixVentePdt;
    private double quantePdt;
    private LocalDate dateLivrasonPdt;
    private LocalDate datePremptonPdt;
    private Categorie categorie;
    @JsonIgnore
    private Collection<Ligne_Commande> ligne_commandes;
    @JsonIgnore
    private Collection<Fournisseur> fournisseurs= new ArrayList<>();
    private Remise remise;
    private ProduitPromo produitPromo;
}
