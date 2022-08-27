package com.example.managershop.service.Impl;

import com.example.managershop.dao.PersonneRepository;
import com.example.managershop.dao.RoleRepository;
import com.example.managershop.entities.Personne;
import com.example.managershop.entities.Role;
import com.example.managershop.entities.User;
import com.example.managershop.exception.NullException;
import com.example.managershop.exception.RessourseNotFounfException;
import com.example.managershop.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;


@Service
@Transactional
public class AccountServiceImpl implements AccountService
{


    @Autowired
    private PersonneRepository personneRepository ;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User saveUser(String username, String password, String confirmedPassword) {

        User user=(User)personneRepository.findByNamePerson(username);
        if(((User)personneRepository.findByNamePerson(username)).equals(null)) throw new RuntimeException("User already exist");
        if(!password.equals(confirmedPassword)) throw new  RuntimeException("Please confirm your password");
        User user1 = User.builder().build();
               // new User();
        user1.setNamePerson(username);
        user1.setActivated(true);
        user1.setPassword(bCryptPasswordEncoder.encode(password));

        //User user1 = User.builder.namePerson(username).activated(true).password(bCryptPasswordEncoder.encode(password)).build();
        personneRepository.save(user1);
        addRoleToUser(username, "USER");
        return user1;
    }

    @Override
    public Role save(Role role) throws NullException {
        if(role.getNameRole().equals(null)) throw new NullException("Must have a value");
        return roleRepository.save(role);
    }

    @Override
    public User loadUserByUsername(String username) {
        if(ObjectUtils.nullSafeEquals(personneRepository.findByNamePerson(username),null)) return null;
        User user=null;
        if(personneRepository.findByNamePerson(username) instanceof User) user=(User) personneRepository.findByNamePerson(username);
        return user;
    }

    @Override
    public void addRoleToUser(String username, String rolename) throws UsernameNotFoundException,RuntimeException {

        /*if(loadUserByUsername(username).equals(null)) throw  new UsernameNotFoundException("Use not exist");
        if(loadRoleByRolename(rolename).equals(null)) throw new RuntimeException("Role not exist");
        if(loadUserByUsername(username).equals(null)) throw new RuntimeException("Nul pointer");*/
        /*loadUserByUsername(username);
        loadRoleByRolename(rolename);*/
        if(CollectionUtils.isEmpty(loadUserByUsername(username).getRoles())) return;
        loadUserByUsername(username).getRoles().add(loadRoleByRolename(rolename));

    }

    @Override
    public Role loadRoleByRolename(String roleName) {
        if(ObjectUtils.nullSafeEquals(roleRepository.findByNameRole(roleName), null)) return null;
        return roleRepository.findByNameRole(roleName);
    }

    @Override
    public User addRoleToUser(Long idUser, Long idRole) {
        //if(!personneRepository.findById(idUser).isPresent()) return null;
        //if(CollectionUtils.isEmpty(((User)personneRepository.findById(idUser).get()).getRoles())) return null;
        ((User)personneRepository.findById(idUser).get()).getRoles().add(roleRepository.findById(idRole).get());
        return (User)personneRepository.findById(idUser).get();
    }

    @Override
    public boolean VerifyIfUserHaveRole(Long idUser, Long idRole) {
        boolean test=false;
        User user = (User) personneRepository.findById(idUser).get();
        Role role = roleRepository.findById(idRole).get();
        Collection<Role> roles = user.getRoles();
        for (Role r : roles) {
            if (ObjectUtils.nullSafeEquals(r, role)) {
              //  roles.remove(r);
                test= true;
            }
        }
        return test;
    }

    @Override
    public User moveRoleToUser(Long idUser, Long idRole) {
        User user = (User) personneRepository.findById(idUser).get();
        Role role = roleRepository.findById(idRole).get();
        if(VerifyIfUserHaveRole(idUser, idRole)== false) return  null;
        user.getRoles().remove(role);
        return user;
    }


}
