package com.example.managershop.service.Impl;

import com.example.managershop.entities.Commande;
import com.example.managershop.service.CommandeService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class CommandeServiceImpl implements CommandeService {
    @Override
    public void AddCommand(Commande cde) {

    }

    @Override
    public void deleteCde(Long idcde) {

    }

    @Override
    public void updateCde(Long idCde, Commande newCde) {

    }

    @Override
    public Collection<Commande> showAllCommande() {
        return null;
    }

    @Override
    public Commande searchCommadeByKeyWord(String keyWord) {
        return null;
    }

    @Override
    public boolean isExistCommand(Long idCde) {
        return false;
    }
}
