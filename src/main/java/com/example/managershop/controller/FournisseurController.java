package com.example.managershop.controller;

import com.example.managershop.dto.CategorieDto;
import com.example.managershop.dto.FournisseurDto;
import com.example.managershop.entities.Categorie;
import com.example.managershop.entities.Fournisseur;
import com.example.managershop.exception.CategorieNotFoundException;
import com.example.managershop.exception.NullException;
import com.example.managershop.exception.RessourseNotFounfException;
import com.example.managershop.service.FournisseurService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/fournisseurs")
public class FournisseurController {

    @Autowired
    private FournisseurService fournisseurService;

    @PostMapping
    @ApiOperation(value = "Create a Fournisseur")
    public ResponseEntity<Fournisseur> createFornisseur(@Valid @RequestBody FournisseurDto fournisseurDto) throws NullException {
        return new ResponseEntity<>(fournisseurService.addfounisseur(fournisseurDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a Fournisseur")
    public ResponseEntity<Fournisseur> deleteFornisseur(@PathVariable("id") String idfsseur) throws NullException, RessourseNotFounfException {
        return new ResponseEntity<>(fournisseurService.deleteFsseur(idfsseur), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Fournisseur>> getAllFsseur() {
        return new ResponseEntity<>(fournisseurService.getAllFsseur(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
        public ResponseEntity<FournisseurDto> updateFnisseur
            (@PathVariable("id") String id, @Valid @RequestBody FournisseurDto fournisseurDto) throws  RessourseNotFounfException {
        return new ResponseEntity<>(fournisseurService.updateFounissueur(id, fournisseurDto), HttpStatus.OK);
    }
}
