package com.example.managershop.dao;

import com.example.managershop.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, Long> {
    public Personne findByNamePerson(String name);
}
