package com.example.managershop.controller;

import com.example.managershop.entities.Categorie;
import com.example.managershop.entities.Personne;
import com.example.managershop.entities.User;
import com.example.managershop.exception.NullException;
import com.example.managershop.service.AccountService;
import com.example.managershop.service.CategorieService;
import com.example.managershop.service.PersonneService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private PersonneService personneService;

    @Autowired
    private AccountService accountService;


    @PostMapping
    @ApiOperation(value = "Create a User")
    public ResponseEntity<User> createCategorie(@Valid @RequestBody User user) throws NullException {
        return new ResponseEntity<>(personneService.saveUser(user), HttpStatus.CREATED);
    }


    @PutMapping("/{idUser}/{idRole}")
    @ApiOperation(value = "Add role to User")
    public ResponseEntity<User> addRoleToUser(@PathVariable("idUser") Long idUser, @PathVariable("idRole") Long idRole) {
        return new ResponseEntity<>(accountService.addRoleToUser(idUser,idRole), HttpStatus.OK);
    }

    @DeleteMapping("/{idUser}/{idRole}")
    @ApiOperation(value = "Move role to User")
    public ResponseEntity<User> moveRoleToUser(@PathVariable("idUser") Long idUser, @PathVariable("idRole") Long idRole) {
        return new ResponseEntity<>(accountService.moveRoleToUser(idUser,idRole), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Personne>> getAllUsers() {
        return new ResponseEntity<>(personneService.getAllUser(), HttpStatus.OK);
    }

}
