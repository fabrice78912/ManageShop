package com.example.managershop.dao;

import com.example.managershop.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Categorie, String> {

    public Categorie findByIdCat(Long idCat);

    @Query("SELECT c FROM Categorie c WHERE c.nomCat LIKE %?1%")
    public List<Categorie> findAll(String keyword);

    public List<Categorie> findByNomCatIgnoreCase(String nameCta);

    @Query("SELECT c FROM Categorie c WHERE c.nomCat LIKE %?1%")
    public List<Categorie> findByNomCatContaining(String nameCta);

}
