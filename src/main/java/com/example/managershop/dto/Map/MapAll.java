package com.example.managershop.dto.Map;

import com.example.managershop.dto.CategorieDto;
import com.example.managershop.dto.RoleDto;
import com.example.managershop.entities.Categorie;
import com.example.managershop.entities.Role;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;


//@Mapper(componentModel = "spring")
public interface MapAll {

    public Categorie categorieDtoToCategorie(CategorieDto categorieDto);
    public CategorieDto categorieToCategorieDt(Categorie categorie);
    public Role roleDtoTorole(RoleDto roleDto);
    public RoleDto roleToroleDto(Role role);


}
