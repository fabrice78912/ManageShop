package com.example.managershop.controller;

import com.example.managershop.dto.AppRoleDto;
import com.example.managershop.dto.CategorieDto;
import com.example.managershop.entities.AppRole;
import com.example.managershop.entities.Categorie;
import com.example.managershop.exception.NullException;
import com.example.managershop.exception.RessourseNotFounfException;
import com.example.managershop.service.AppRoleService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class AppRoleController {

    private final AppRoleService appRoleService;

    @PostMapping
    @ApiOperation(value = "Create a Role")
    public ResponseEntity<AppRole> createRole(@Valid @RequestBody AppRoleDto appRoleDto) throws RessourseNotFounfException {
        return new ResponseEntity<>(appRoleService.saveRole(appRoleDto), HttpStatus.CREATED);
    }

    @GetMapping
    @ApiOperation(value = "Liste All Roles")
    public ResponseEntity<Collection<AppRole>> getAllRoles() {
        return new ResponseEntity<>(appRoleService.getAllRoles(), HttpStatus.OK);
    }

    @GetMapping("/shorted")
    @ApiOperation(value = "List all roles shorted")
    public ResponseEntity<Collection<AppRole>> getAllRolesShorted() {
        return new ResponseEntity<>(appRoleService.getAllRoleShorted(), HttpStatus.OK);
    }

    @GetMapping("/{rolename}")
    @ApiOperation(value = "CGet Role By role name")
    public ResponseEntity<AppRole> getRoleByRolename(@PathVariable("rolename") String rolename) throws RessourseNotFounfException {
        return new ResponseEntity<>(appRoleService.getRoleByRolename(rolename), HttpStatus.OK);
    }

    @DeleteMapping("/{rolename}")
    public ResponseEntity<AppRole> deleteRole(@PathVariable("rolename") String rolename) throws RessourseNotFounfException {
        return new ResponseEntity<>(appRoleService.deleRole(rolename), HttpStatus.OK);
    }

    @PutMapping("/{idrole}")
    public ResponseEntity<AppRole> UpdateRole(@PathVariable("idrole") String idrole,@Valid @RequestBody AppRoleDto appRoleDto) throws RessourseNotFounfException {
        return new ResponseEntity<>(appRoleService.updateRole(idrole, appRoleDto), HttpStatus.OK);
    }
}
