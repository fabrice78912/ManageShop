package com.example.managershop.dao;

import com.example.managershop.entities.Remise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RemiseRepository extends JpaRepository<Remise, Long> {
}
