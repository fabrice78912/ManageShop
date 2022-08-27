package com.example.managershop.service.Impl;

import com.example.managershop.dao.PersonneRepository;
import com.example.managershop.entities.Client;
import com.example.managershop.entities.Personne;
import com.example.managershop.entities.User;
import com.example.managershop.exception.NullException;
import com.example.managershop.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PersonneServiceImpl implements PersonneService {

    @Autowired
    private PersonneRepository personneRepository;
    @Override
    public Client saveClient(Client c) {
        if(!loadClientByUsername(c.getLastNamePerson()).equals(null)) throw new RuntimeException("Client already exist !!");
        return personneRepository.save(c);
    }



    @Override
    public User saveUser(User u) throws NullException {
        if (ObjectUtils.nullSafeEquals(u, null)) throw new NullException("User cant be null !!");
        return (User)personneRepository.save(u);
    }

    @Override
    public Client updateClient(String clientName, Client newClient) {
        Client client=(Client)personneRepository.findByNamePerson(clientName);
          if(client.equals(null)) throw new RuntimeException("Client not exist");
          client.setCivilitePerson(newClient.getCivilitePerson());
          client.setEmailPerson(newClient.getEmailPerson());
          client.setNamePerson(newClient.getNamePerson());
          client.setLastNamePerson(newClient.getLastNamePerson());
          client.setNumCniPerson(newClient.getNumCniPerson());
          client.setVillePerson(newClient.getVillePerson());
          client.setSoldeCredit(newClient.getSoldeCredit());
          client.setSoldeDebit(newClient.getSoldeDebit());
          client.setCommandes(newClient.getCommandes());
          return personneRepository.save(client);
    }

    @Override
    public Client loadClientByUsername(String username) {
        return (Client) personneRepository.findByNamePerson(username);
    }

    @Override
    public Client deleteCleint(Client c) {
          if(loadClientByUsername(c.getLastNamePerson()).equals(null)) throw new RuntimeException("Client not found");
          personneRepository.delete(c);
        return c;
    }

    @Override
    public User updateUser(Long idUser, User newUser) {
        User user= loadUserByid(idUser);
        if(user.equals(null)) throw new RuntimeException("user not exist");
        user.setCivilitePerson(newUser.getCivilitePerson());
        user.setEmailPerson(newUser.getEmailPerson());
        user.setNamePerson(newUser.getNamePerson());
        user.setLastNamePerson(newUser.getLastNamePerson());
        user.setNumCniPerson(newUser.getNumCniPerson());
        user.setVillePerson(newUser.getVillePerson());
        if(newUser.getPassword().equals(newUser.getPasswordConfirmed())) throw new RuntimeException("Please Confirme your passWord");
        user.setPassword(newUser.getPassword());
        user.setPhoto(newUser.getPhoto());
        return personneRepository.save(user);
    }

    @Override
    public User deleteUser(Long idUser) {
        User user=loadUserByid(idUser);
        if(loadUserByid(idUser).equals(null)) throw new RuntimeException("User not found");
         personneRepository.delete(loadUserByid(idUser));
         return user;
    }

    @Override
    public User loadUserByid(Long idUser) {
        return (User)personneRepository.findById(idUser).get();
    }

    @Override
    public List<Personne> getAllUser() {
        return personneRepository.findAll();
    }
}
