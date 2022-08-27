package com.example.managershop.service;

import com.example.managershop.dto.ProduitDto;
import com.example.managershop.entities.Produit;
import com.example.managershop.exception.NullException;
import com.example.managershop.exception.RessourseNotFounfException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public interface ProduitService {
    public Produit savePdt(String idCat , ProduitDto produitDto) throws RessourseNotFounfException;
    public Produit deletePdt(String idPdt) throws RessourseNotFounfException;
    public Produit updadePdt(String idPdt , ProduitDto newPdtProduitDto) throws RessourseNotFounfException, NullException;
    public Produit getPdtById(String idPdt) throws RessourseNotFounfException;
    public List<Produit> searchPdtByName(String namePdt) throws RessourseNotFounfException;
    public List<Produit> getAllPdt();
    public Produit changeCategoryProduct(String idCat, String idPdt);
    public Collection<Produit> getAllProductByCategory(String idCat) throws RessourseNotFounfException;
    public List<Produit> getProductByCategorie1(String idcat) throws RessourseNotFounfException;
    public void payerPduit(String idPdt , double qtePdruitPaye);
    public Double CommaderPrduits (List<Produit> produits);
}
