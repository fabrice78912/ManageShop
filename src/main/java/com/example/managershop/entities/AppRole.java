package com.example.managershop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class AppRole {
    @Id
    private String idRole;
    private String rolename;

}
