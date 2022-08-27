package com.example.managershop.service;


import com.example.managershop.entities.Client;
import com.example.managershop.entities.Personne;
import com.example.managershop.entities.User;
import com.example.managershop.exception.NullException;

import java.util.List;

public interface PersonneService {

    public Client saveClient(Client c);
    public User saveUser(User u) throws NullException;
    public Client updateClient(String clientName , Client newClient);
    public Client loadClientByUsername(String username);
    public Client deleteCleint(Client c);
    public User updateUser(Long idUser , User newUser);
    public User deleteUser(Long idUser);
    public User loadUserByid(Long idUser);
    public List<Personne> getAllUser();
}
