package com.example.managershop.service;

import com.example.managershop.dto.AppRoleDto;
import com.example.managershop.dto.AppUserDto;
import com.example.managershop.entities.AppRole;
import com.example.managershop.entities.AppUser;
import com.example.managershop.exception.RessourseNotFounfException;

import java.util.Collection;

public interface AppUserService {

    public AppUser saveUser(AppUserDto appUserDto);
    public AppUser deleUser(String Username) throws RessourseNotFounfException;
    public AppUser updateUser(String iUser, AppUserDto appUserDto) throws RessourseNotFounfException;
    public Collection<AppUser> getAllUser();
    public AppUser getUserByUsername(String username);
    public AppUser addRoleToUser(String idrole, String iduser) throws RessourseNotFounfException;
    public Collection<AppRole> getAllRoleByUser(String iduser) throws RessourseNotFounfException;

}
