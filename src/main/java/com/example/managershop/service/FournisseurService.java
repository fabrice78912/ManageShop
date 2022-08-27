package com.example.managershop.service;


import com.example.managershop.dto.CategorieDto;
import com.example.managershop.dto.FournisseurDto;
import com.example.managershop.entities.Categorie;
import com.example.managershop.entities.Fournisseur;
import com.example.managershop.entities.Produit;
import com.example.managershop.exception.NullException;
import com.example.managershop.exception.RessourseNotFounfException;

import java.util.List;

public interface FournisseurService {

    public Fournisseur addfounisseur(FournisseurDto fournisseurDto) throws NullException;
    public List<Fournisseur> getAllFsseur();
    public Fournisseur getFsseurById(String idfsseur) throws RessourseNotFounfException;
    public Fournisseur deleteFsseur(String idfsseur) throws RessourseNotFounfException;
    public List<Produit> livrerProduit(String idfsseur, Long idPdt);

    public FournisseurDto updateFounissueur(String idCat, FournisseurDto newFournisseur) throws RessourseNotFounfException;

}
