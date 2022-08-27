package com.example.managershop.dao;

import com.example.managershop.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface AppUserRepository extends JpaRepository<AppUser, String> {
    AppUser findByUsername(String username);
    //Collection<AppUser> findByAgeOrderByUsernameDesc();
}
