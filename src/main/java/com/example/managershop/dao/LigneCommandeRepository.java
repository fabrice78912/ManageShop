package com.example.managershop.dao;

import com.example.managershop.entities.Ligne_Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneCommandeRepository extends JpaRepository<Ligne_Commande, Long> {
}
