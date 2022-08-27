package com.example.managershop.service.Impl;

import com.example.managershop.dao.PersonneRepository;
import com.example.managershop.dao.RoleRepository;
import com.example.managershop.entities.Role;
import com.example.managershop.entities.User;
import com.example.managershop.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PersonneRepository personneRepository;
    @Override
    public Role updateRole(Long idRole, Role newRole) {

        Role role= loadRoleById(idRole);
        if(role.equals(null)) throw new RuntimeException("role not exist");
        role.setNameRole(newRole.getNameRole());
        role.setUsers(role.getUsers());
        role.setLevelPriorite(role.getLevelPriorite());
        roleRepository.save(role);
        return  role;
    }

    @Override
    public String deleteRole(Role role) {
        if(loadRoleById(role.getIdRole()).equals(null)) throw new RuntimeException("Role not exist");
        roleRepository.delete(role);
        return role.getNameRole()+" delete !!";
    }

    @Override
    public Role loadRoleById(Long idRole) {
        return roleRepository.findById(idRole).get();
    }

    @Override
    public Collection<Role> listRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Collection<Role> allRoleUser(Long idUser) {
        return ((User)personneRepository.findById(idUser).get()).getRoles();
    }

}
