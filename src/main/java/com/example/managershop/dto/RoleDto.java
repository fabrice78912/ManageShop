package com.example.managershop.dto;

import com.example.managershop.entities.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;

@Data @AllArgsConstructor @NoArgsConstructor @ToString @Builder
public class RoleDto {
    private Long idRole;
    @NotNull
    private String nameRole;
    private int levelPriorite;
    private Collection<User> users= new ArrayList<>();

}
