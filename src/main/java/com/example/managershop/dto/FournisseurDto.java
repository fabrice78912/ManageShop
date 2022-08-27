package com.example.managershop.dto;

import com.example.managershop.entities.Produit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class FournisseurDto {

    @JsonIgnore
    private String idFsseur;
    @NotNull
    private String nameFsseur;
    @NotNull
    private String phoneFsseur;
    private String addresseFsseur;
    //@Email
    private String emailFsseur;
    private String villeFsseur;
    private String paysFsseur;
    @JsonIgnore
    private Collection<Produit> produits= new ArrayList<>();
}
