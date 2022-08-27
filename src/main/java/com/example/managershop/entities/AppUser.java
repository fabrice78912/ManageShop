package com.example.managershop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {

    @Id
    private String idUser;
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    Collection<AppRole> appRoles= new ArrayList<>();
}
