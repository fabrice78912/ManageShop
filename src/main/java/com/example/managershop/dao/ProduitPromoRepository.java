package com.example.managershop.dao;

import com.example.managershop.entities.ProduitPromo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitPromoRepository extends JpaRepository<ProduitPromo, Long> {
}
