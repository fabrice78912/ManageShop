package com.example.managershop.dao;

import com.example.managershop.entities.AppRole;
import com.example.managershop.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface AppRoleRepository extends JpaRepository<AppRole, String> {
    AppRole findByRolename(String rolename);

    @Query(
            value = "SELECT * FROM APP_ROLE r ORDER BY r.ROLENAME ASC",
            nativeQuery = true)
    public Collection<AppRole> getALLRolleShorted();
    public AppRole findByIdRole(String idrole);

}
