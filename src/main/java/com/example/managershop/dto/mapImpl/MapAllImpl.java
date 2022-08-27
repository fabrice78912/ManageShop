package com.example.managershop.dto.mapImpl;

import com.example.managershop.dto.CategorieDto;
import com.example.managershop.dto.Map.MapAll;
import com.example.managershop.dto.RoleDto;
import com.example.managershop.entities.Categorie;
import com.example.managershop.entities.Role;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapAllImpl implements MapAll {

    @Autowired
    private ModelMapper modelMapper;

   /* public MapAllImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
*/
    @Override
    public Categorie categorieDtoToCategorie(CategorieDto categorieDto) {
        Categorie categorie= modelMapper.map(categorieDto,Categorie.class);
        return categorie;
    }

    @Override
    public CategorieDto categorieToCategorieDt(Categorie categorie) {

        return  modelMapper.map(categorie, CategorieDto.class);
    }

    @Override
    public Role roleDtoTorole(RoleDto roleDto) {
        return modelMapper.map(roleDto, Role.class);
    }

    @Override
    public RoleDto roleToroleDto(Role role) {
        return modelMapper.map(role, RoleDto.class);
    }
}
