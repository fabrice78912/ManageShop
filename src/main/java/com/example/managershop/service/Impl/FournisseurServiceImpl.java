package com.example.managershop.service.Impl;

import com.example.managershop.dao.FounisseurRepository;
import com.example.managershop.dto.FournisseurDto;
import com.example.managershop.dto.Map.MapperEntities;
import com.example.managershop.entities.Fournisseur;
import com.example.managershop.entities.Produit;
import com.example.managershop.exception.NullException;
import com.example.managershop.exception.RessourseNotFounfException;
import com.example.managershop.service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class FournisseurServiceImpl implements FournisseurService {
    @Autowired
    private FounisseurRepository founisseurRepository;
    @Autowired
    private MapperEntities mapperEntities;

    @Override
    public Fournisseur addfounisseur(FournisseurDto fournisseurDto) throws NullException {
        if(fournisseurDto.getNameFsseur().equals(null)
        || fournisseurDto.getPhoneFsseur().equals(null)
        || fournisseurDto.getAddresseFsseur().equals(null)
        || fournisseurDto.getPaysFsseur().equals(null)
        || fournisseurDto.getVilleFsseur().equals(null)) throw new NullException("Must have a value");
        Fournisseur fournisseur=mapperEntities.FournisserDTOFournisseur(fournisseurDto);
        fournisseur.setIdFsseur(UUID.randomUUID().toString());
        founisseurRepository.save(fournisseur);
        return fournisseur;
    }

    @Override
    public List<Fournisseur> getAllFsseur() {
        return founisseurRepository.findAll();
    }

    @Override
    public Fournisseur getFsseurById(String idfsseur) throws RessourseNotFounfException {
        if(!founisseurRepository.findById(idfsseur).isPresent()) throw new
                RessourseNotFounfException("Fournisseur With id :"+idfsseur+" not found");
        return founisseurRepository.findById(idfsseur).get();
    }

    @Override
    public Fournisseur deleteFsseur(String idfsseur) throws RessourseNotFounfException {
        if(!founisseurRepository.findById(idfsseur).isPresent()) throw new
                RessourseNotFounfException("Fournisseur With id :"+idfsseur+" not found");
        Fournisseur fournisseur=founisseurRepository.findById(idfsseur).get();
        founisseurRepository.delete(founisseurRepository.findById(idfsseur).get());
        return fournisseur;
    }

    @Override
    public List<Produit> livrerProduit(String idfsseur, Long idPdt) {
        return null;
    }

    @Override
    public FournisseurDto updateFounissueur(String idfseur, FournisseurDto newFournisseur) throws RessourseNotFounfException {
        if(!founisseurRepository.findById(idfseur).isPresent()) throw new
                RessourseNotFounfException("Fournisseur With id :"+idfseur+" not found");

        Fournisseur fournisseur=mapperEntities.FournisseurDTOFournisseur(newFournisseur);
        fournisseur.setIdFsseur(idfseur);
        founisseurRepository.save(fournisseur);
        return mapperEntities.FournisseurToFournisseurDTO(fournisseur);
    }
}
