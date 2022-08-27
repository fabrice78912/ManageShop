package com.example.managershop.service;

import com.example.managershop.dto.AppRoleDto;
import com.example.managershop.entities.AppRole;
import com.example.managershop.exception.RessourseNotFounfException;

import java.util.Collection;

public interface AppRoleService {
    public AppRole saveRole(AppRoleDto appRoleDto) throws RessourseNotFounfException;
    public AppRole deleRole(String rolename) throws RessourseNotFounfException;
    public AppRole updateRole(String idrole, AppRoleDto appRoleDto) throws RessourseNotFounfException;
    public Collection<AppRole> getAllRoles();
    public AppRole getRoleByRolename(String rolename) throws RessourseNotFounfException;
    public Collection<AppRole> getAllRoleShorted();

}
