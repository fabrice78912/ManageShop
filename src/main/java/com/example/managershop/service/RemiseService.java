package com.example.managershop.service;


import com.example.managershop.dto.ProduitDto;
import com.example.managershop.exception.RessourseNotFounfException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public interface RemiseService {

    public Double appliquerRemise(String idpdt , int pourcentageRemise) throws RessourseNotFounfException;
}
