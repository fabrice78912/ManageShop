package com.example.managershop.service.Impl;

import com.example.managershop.dao.AppRoleRepository;
import com.example.managershop.dto.AppRoleDto;
import com.example.managershop.dto.Map.MapperEntities;
import com.example.managershop.entities.AppRole;
import com.example.managershop.exception.RessourseNotFounfException;
import com.example.managershop.service.AppRoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AppRoleServiceImpl implements AppRoleService {

    private final AppRoleRepository appRoleRepository;
    private final MapperEntities mapperEntities;

    @Override
    public AppRole saveRole(AppRoleDto appRoleDto) throws RessourseNotFounfException {
        AppRole appRole = mapperEntities.AppRoleDTOAppRole(appRoleDto);
        String idroleGenreted = UUID.randomUUID().toString();
        int i = 0;
        while (i < 5 && !ObjectUtils.isEmpty(appRoleRepository.findByIdRole(idroleGenreted))) {
            i++;
            idroleGenreted = UUID.randomUUID().toString();
            log.info("Id role genereted is {} ", idroleGenreted );
        }

        if (!ObjectUtils.isEmpty(appRoleRepository.findByIdRole(idroleGenreted))) {
            log.error("Role dont save because id dont genereted");
            throw new RessourseNotFounfException("Role dont save because id role dont generated");
        }

        appRole.setIdRole(idroleGenreted);
        AppRole appRoleSaved= appRoleRepository.save(appRole);
        log.info("Role {} saved with success", appRoleSaved  );
        return appRoleSaved;
    }

    @Override
    public AppRole deleRole(String rolename) throws RessourseNotFounfException {
        AppRole appRole= appRoleRepository.findByRolename(rolename);
        if(ObjectUtils.isEmpty(appRole)){
            log.error("Approle with role name  {} not exist", rolename);
            throw new RessourseNotFounfException("Role with name"+rolename+" not found");
        }
        appRoleRepository.delete(appRoleRepository.findByRolename(rolename));
        return appRole;
    }

    @Override
    public AppRole updateRole(String idrole, AppRoleDto appRoleDto) throws RessourseNotFounfException {

        if(!appRoleRepository.findById(idrole).isPresent())
            //if(ObjectUtils.isEmpty(appRoleRepository.findById(idrole)))
        {
            log.error("Approle with id {} not exist", idrole);
            throw new RessourseNotFounfException("Role with id"+idrole+" not found");
        }
        AppRole appRole= appRoleRepository.findById(idrole).get();
        appRole.setRolename(appRoleDto.getRolename());
        return appRoleRepository.save(appRole);
    }


    @Override
    public Collection<AppRole> getAllRoles() {
        return appRoleRepository.findAll();
    }

    @Override
    public AppRole getRoleByRolename(String rolename) throws RessourseNotFounfException {
        if(ObjectUtils.isEmpty(appRoleRepository.findByRolename(rolename))) throw new RessourseNotFounfException("Not fount");
        return appRoleRepository.findByRolename(rolename);
    }

    @Override
    public Collection<AppRole> getAllRoleShorted() {
       return appRoleRepository.getALLRolleShorted();
    }
}
