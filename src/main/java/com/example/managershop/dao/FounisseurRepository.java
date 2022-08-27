package com.example.managershop.dao;

import com.example.managershop.entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FounisseurRepository extends JpaRepository<Fournisseur, String> {
}
