package com.example.managershop.controller;

import com.example.managershop.dto.AppRoleDto;
import com.example.managershop.dto.AppUserDto;
import com.example.managershop.entities.AppRole;
import com.example.managershop.entities.AppUser;
import com.example.managershop.exception.RessourseNotFounfException;
import com.example.managershop.service.AppUserService;
import com.example.managershop.service.Impl.AppRoleServiceImpl;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class AppUserController {
    private final AppUserService appUserService;

    @PostMapping
    @ApiOperation(value = "Create a User")
    public ResponseEntity<AppUser> createUser(@Valid @RequestBody AppUserDto appUserDto){
        return new ResponseEntity<>(appUserService.saveUser(appUserDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Collection<AppUser>> getAllUsers() {
        return new ResponseEntity<>(appUserService.getAllUser(), HttpStatus.OK);
    }


    @GetMapping("/{username}")
    public ResponseEntity<AppUser> getUserByUsername(@PathVariable("username") String username){
        return new ResponseEntity<>(appUserService.getUserByUsername(username), HttpStatus.OK);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<AppUser> deleteUser(@PathVariable("username") String username) throws RessourseNotFounfException {
        return new ResponseEntity<>(appUserService.deleUser(username), HttpStatus.OK);
    }

    @PutMapping("/{iduser}")
    public ResponseEntity<AppUser> UpdateUser(@PathVariable("iduser") String iduser,@Valid @RequestBody AppUserDto appUserDto) throws RessourseNotFounfException {
        return new ResponseEntity<>(appUserService.updateUser(iduser, appUserDto), HttpStatus.OK);
    }


    @GetMapping("/roles/{iduser}")
    public ResponseEntity<Collection<AppRole>> getAllRoleByUser(@PathVariable("iduser") String iduser) throws RessourseNotFounfException {
        return new ResponseEntity<>(appUserService.getAllRoleByUser(iduser), HttpStatus.OK);
    }


    @PostMapping("/{idrole}/{iduser}")
    @ApiOperation(value = "Add role to user")
    public ResponseEntity<AppUser> addRoleToUser(@PathVariable("idrole") String idrole, @PathVariable("iduser") String iduser) throws RessourseNotFounfException {
        return new ResponseEntity<>(appUserService.addRoleToUser(idrole, iduser), HttpStatus.CREATED);
    }

}
