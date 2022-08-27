package com.example.managershop.controller;

import com.example.managershop.dto.ProduitDto;
import com.example.managershop.entities.Produit;
import com.example.managershop.exception.NullException;
import com.example.managershop.exception.RessourseNotFounfException;
import com.example.managershop.service.ProduitService;
import com.example.managershop.service.RemiseService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/remise")
@RequiredArgsConstructor
public class RemiseController {

    //@Autowired
    private RemiseService remiseService;

    @PutMapping("/{idpdt}/{remise}")
    @ApiOperation(value = "Make remise")
    public ResponseEntity<Double> createPdt(@PathVariable String idpdt, @PathVariable int remise) throws NullException, RessourseNotFounfException {
        return new ResponseEntity<>(remiseService.appliquerRemise(idpdt, remise), HttpStatus.OK);
    }
}
