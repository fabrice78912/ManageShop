package com.example.managershop.service;

import com.example.managershop.entities.Categorie;
import com.example.managershop.entities.Produit;
import com.example.managershop.exception.CategorieNotFoundException;
import com.example.managershop.exception.NullException;
import com.example.managershop.exception.RessourseNotFounfException;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.List;


public interface CategorieService {
    public Categorie findByIdcat(String idcat) throws RessourseNotFounfException;
    public Categorie addCategory(Categorie c) throws NullException;
    public boolean isExistCat(String idCat);
    public Categorie updateCat(String idCat, Categorie newCat) throws CategorieNotFoundException, RessourseNotFounfException;
    public Categorie deleteCat(String idCat) throws CategorieNotFoundException, RessourseNotFounfException;
    public List<Categorie> findAll(String keyword);
    public List<Categorie> findAll();
    public List<Categorie> findAllSort();
    public Categorie addProductToCategorie(String idPdt, String idCat) throws RessourseNotFounfException;
    public Categorie deleteProductToCategorie(Long idPdt , String idCat);
    public Categorie deleteProductToCategorie(List<Produit> produits , String idCat);
    public Collection<Produit> getProductByCategorie(String idCat) throws RessourseNotFounfException;
    public Page<Categorie> listePaginedCategorie(int page, int size, String sortfield, String SortDirection);
    public List<Categorie> getCatByNameIgnoreCase(String nameCat) throws RessourseNotFounfException;
    public List<Categorie> getCatByNameContaining(String nameCat) throws RessourseNotFounfException;

}
