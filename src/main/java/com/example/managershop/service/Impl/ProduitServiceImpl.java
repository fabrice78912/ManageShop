package com.example.managershop.service.Impl;

import com.example.managershop.dao.CategoryRepository;
import com.example.managershop.dao.ProduitRepository;
import com.example.managershop.dto.Map.MapperEntities;
import com.example.managershop.dto.ProduitDto;
import com.example.managershop.entities.Categorie;
import com.example.managershop.entities.Produit;
import com.example.managershop.exception.NullException;
import com.example.managershop.exception.RessourseNotFounfException;
import com.example.managershop.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ProduitServiceImpl implements ProduitService {
    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private MapperEntities mapperEntities;
    @Override
    public Produit savePdt(String idCat, ProduitDto produitDto) throws RessourseNotFounfException {
        if(!categoryRepository.findById(idCat).isPresent()) throw new
                RessourseNotFounfException("Category with Id :"+idCat+" not found");
        Produit produit= mapperEntities.ProduitDTOProduit(produitDto);
        produit.setIdPdt(UUID.randomUUID().toString());
        produit.setCategorie(categoryRepository.findById(idCat).get());
        produitRepository.save(produit);
        return produit;
    }

    @Override
    public Produit deletePdt(String idPdt) throws RessourseNotFounfException {
        if(!produitRepository.findById(idPdt).isPresent()) throw new RessourseNotFounfException("Product with Id :"+idPdt+" not found");
        Produit produit=produitRepository.findById(idPdt).get();
        produitRepository.delete(produitRepository.findById(idPdt).get());
        return produit;
    }

    @Override
    public Produit updadePdt(String idPdt, ProduitDto newproduitDto) throws RessourseNotFounfException, NullException {

        if(!produitRepository.findById(idPdt).isPresent()) throw new
                RessourseNotFounfException("Product with Id :"+idPdt+" not found");
        if(newproduitDto.equals(null)) throw new NullException("is empty");
        Produit newproduit= mapperEntities.ProduitDTOProduit(newproduitDto);
        //produitRepository.findById(idPdt).get().setNomPdt(newproduit.getNomPdt());
        //produitRepository.findById(idPdt).get().setCategorie(newproduit.getCategorie());
        /*produitRepository.findById(idPdt).get().setPrixAchatPdt(newproduit.getPrixAchatPdt());
        produitRepository.findById(idPdt).get().setPrixVentePdt(newproduit.getPrixVentePdt());
        produitRepository.findById(idPdt).get().setQuantePdt(newproduit.getQuantePdt());
        produitRepository.findById(idPdt).get().setDateLivrasonPdt(newproduit.getDateLivrasonPdt());
        produitRepository.findById(idPdt).get().setDatePremptonPdt(newproduit.getDatePremptonPdt());
        produitRepository.findById(idPdt).get().setRemise(newproduit.getRemise());*/
        return produitRepository.save(newproduit);
    }

    @Override
    public Produit getPdtById(String idPdt) throws RessourseNotFounfException {
        if(!produitRepository.findById(idPdt).isPresent()) throw new RessourseNotFounfException("Product with id :"+idPdt+" not not exist");
        return produitRepository.findById(idPdt).get();
    }

    @Override
    public List<Produit> searchPdtByName(String namePdt) throws RessourseNotFounfException {
        if (produitRepository.findByNomPdtContaining(namePdt).isEmpty()) throw new RessourseNotFounfException("is empty");
        return produitRepository.findByNomPdtContaining(namePdt);
    }

    @Override
    public List<Produit> getAllPdt() {
        return produitRepository.findAll();
    }

    @Override
    public Produit changeCategoryProduct(String idCat, String idPdt) {
        return null;
    }

    @Override
    public Collection<Produit> getAllProductByCategory(String idCat) throws RessourseNotFounfException {
        if(!categoryRepository.findById(idCat).isPresent()) throw new RessourseNotFounfException("Category with id :"+idCat+" not not exist");
        return categoryRepository.findById(idCat).get().getProduits();
    }

    @Override
    public List<Produit> getProductByCategorie1(String idcat) throws RessourseNotFounfException {
        if(!categoryRepository.findById(idcat).isPresent()) throw new RessourseNotFounfException("Category with id :"+idcat+" not not exist");
        Categorie categorie= categoryRepository.findById(idcat).get();
        return produitRepository.findByCategorie(categorie);
    }

    @Override
    public void payerPduit(String idPdt, double qtePdruitPaye) {

    }

    @Override
    public Double CommaderPrduits(List<Produit> produits) {
        return null;
    }

}
