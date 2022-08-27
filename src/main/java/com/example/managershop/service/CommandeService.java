package com.example.managershop.service;


import com.example.managershop.entities.Commande;

import java.util.Collection;

public interface CommandeService {
    public void AddCommand(Commande cde);
    public void deleteCde(Long idcde);
    public void updateCde(Long idCde, Commande newCde);
    public Collection<Commande> showAllCommande();
    public Commande searchCommadeByKeyWord(String keyWord);
    public boolean isExistCommand(Long idCde);

}
