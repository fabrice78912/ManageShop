package com.example.managershop.service;


import com.example.managershop.entities.Role;

import java.util.Collection;

public interface RoleService {

    public Role updateRole(Long idRole, Role newRole );
    public String deleteRole(Role role);
    public Role loadRoleById(Long idRole);
    public Collection<Role> listRoles();
    public Collection<Role> allRoleUser(Long idUser);
}
