package com.example.managershop.service.Impl;

import com.example.managershop.dao.AppRoleRepository;
import com.example.managershop.dao.AppUserRepository;
import com.example.managershop.dto.AppUserDto;
import com.example.managershop.dto.Map.MapperEntities;
import com.example.managershop.entities.AppRole;
import com.example.managershop.entities.AppUser;
import com.example.managershop.exception.RessourseNotFounfException;
import com.example.managershop.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.UUID;
//@Slf4j
@Service @Transactional @RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {

    private static final Logger LOGGER= LoggerFactory.getLogger(AppUserServiceImpl.class);

    private final AppRoleRepository appRoleRepository;
    private final MapperEntities mapperEntities;
    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public AppUser saveUser(AppUserDto appUserDto) {
        if(appUserRepository.findByUsername(appUserDto.getUsername())!=null) throw  new RuntimeException("User already exist");
        AppUser appUser= mapperEntities.AppUserDTOAppUser(appUserDto);
        appUser.setIdUser(UUID.randomUUID().toString());
        appUser.setPassword(bCryptPasswordEncoder.encode(appUserDto.getPassword())); // Crypte le pwd
        LOGGER.info("Saving new User {} to the database ", appUserDto.getUsername());
        return appUserRepository.save(appUser);
    }

    @Override
    public AppUser deleUser(String Username) throws RessourseNotFounfException {
        AppUser appUser= appUserRepository.findByUsername(Username);
        if(appUser.equals(null)) throw new RessourseNotFounfException("User with name"+Username+" not found");
        appUserRepository.delete(appUserRepository.findByUsername(Username));
        return appUser;
    }

    @Override
    public AppUser updateUser(String iUser, AppUserDto appUserDto) throws RessourseNotFounfException {
        if(!appUserRepository.findById(iUser).isPresent()) throw
                new RessourseNotFounfException("User with id"+iUser+" not found");
        AppUser appUser= appUserRepository.findById(iUser).get();
        appUser.setUsername(appUserDto.getUsername());
        appUser.setPassword(bCryptPasswordEncoder.encode(appUserDto.getPassword()));
        return appUserRepository.save(appUser);
    }

    @Override
    public Collection<AppUser> getAllUser() {
        return appUserRepository.findAll();
    }

    @Override
    public AppUser getUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public AppUser addRoleToUser(String idrole, String iduser) throws RessourseNotFounfException {
        if(!appUserRepository.findById(iduser).isPresent()) throw
                new RessourseNotFounfException("User wit Id"+ iduser+" not exist");
        if(!appRoleRepository.findById(idrole).isPresent()) throw
                new RessourseNotFounfException("Role wit Id"+ idrole+" not exist");
        AppUser appUser=appUserRepository.findById(iduser).get();
        AppRole appRole=appRoleRepository.findById(idrole).get();
        //if(appUser.getAppRoles().isEmpty()) throw new
        if(appUser.getAppRoles()== null) throw new NullPointerException(" Null poiter exception");
       /* AppRole appRole1 = appUser.getAppRoles().stream()
                .filter(role -> (appRole.getRolename()).equals(role.getRolename()))
                .findAny()
                .orElse(null);
        if(!appRole1.equals(null)) throw new RuntimeException("Role alredy assign to this User");*/
        appUser.getAppRoles().add(appRole);
        return appUserRepository.save(appUser);
    }

    @Override
    public Collection<AppRole> getAllRoleByUser(String iduser) throws RessourseNotFounfException {
        if(!appUserRepository.findById(iduser).isPresent()) throw
                new RessourseNotFounfException("User wit Id"+ iduser+" not exist");
        return appUserRepository.findById(iduser).get().getAppRoles();
    }
}
