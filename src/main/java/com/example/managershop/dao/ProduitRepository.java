package com.example.managershop.dao;

import com.example.managershop.entities.Categorie;
import com.example.managershop.entities.Produit;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, String> {


    @Query("SELECT p FROM Produit p WHERE p.nomPdt LIKE %?1%")
    public List<Produit> searchPdtByKeyword(String keyword);
    public List<Produit> findByCategorie(Categorie categorie);
    public List<Produit> findByNomPdtContaining(String keyword);
    public List<Produit> findByNomPdtLike(String keyword);
    public List<Produit> findByNomPdtLike(String keyword, Sort sort);
}
