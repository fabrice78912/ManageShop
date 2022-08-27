package com.example.managershop.dao;

import com.example.managershop.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    public Role findByNameRole(String nameRole);
}
