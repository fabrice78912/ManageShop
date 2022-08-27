package com.example.managershop.service.Impl;

import com.example.managershop.dao.ProduitRepository;
import com.example.managershop.dto.Map.MapperEntities;
import com.example.managershop.dto.ProduitDto;
import com.example.managershop.entities.Produit;
import com.example.managershop.exception.RessourseNotFounfException;
import com.example.managershop.service.RemiseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RemiseServiceImpl implements RemiseService {


    private MapperEntities mapperEntities;
    private ProduitRepository produitRepository;
    @Override
    public Double appliquerRemise(String idpdt, int pourcentageRemise) throws RessourseNotFounfException {
        if(!produitRepository.findById(idpdt).isPresent()) throw new RessourseNotFounfException("Product with id :"+idpdt+" not not exist");
        Produit produit= produitRepository.findById(idpdt).get();
        double remise= (produit.getPrixVentePdt()*pourcentageRemise)/100.0;
        return produit.getPrixVentePdt()-remise;
    }
}
