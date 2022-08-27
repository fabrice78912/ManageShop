package com.example.managershop.service;


import com.example.managershop.entities.Role;
import com.example.managershop.entities.User;
import com.example.managershop.exception.NullException;

import java.util.List;


public interface AccountService {

    public User saveUser(String username, String password , String confirmedPassword);

    /**
     * @param role
     * @return Role
     *
     */
    public Role save(Role role) throws NullException;

    /**
     *
     * @param username
     * @return User
     */
    public User loadUserByUsername( String username);

    /**
     *
     * @param username
     * @param rolename
     */
    public void addRoleToUser (String username , String rolename);
    public Role loadRoleByRolename(String roleName);
    public User addRoleToUser(Long idUser, Long idRole);
    public boolean VerifyIfUserHaveRole(Long idUser, Long idRole);
    public User moveRoleToUser(Long idUser, Long idRole);


}
