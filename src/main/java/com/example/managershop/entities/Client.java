package com.example.managershop.entities;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Builder
@Data @AllArgsConstructor @NoArgsConstructor
@DiscriminatorValue("CLT")
public class Client extends Personne{

    private double soldeDebit;
    private double soldeCredit;
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    //@JoinColumn(name = "id_client1")
    private Collection<Commande> commandes = new ArrayList<>();

   /* public double getSoldeDebit() {
        return soldeDebit;
    }

    public double getSoldeCredit() {
        return soldeCredit;
    }

    public Collection<Commande> getCommandes() {
        return commandes;
    }

    public void setSoldeDebit(double soldeDebit) {
        this.soldeDebit = soldeDebit;
    }

    public void setSoldeCredit(double soldeCredit) {
        this.soldeCredit = soldeCredit;
    }

    public void setCommandes(Collection<Commande> commandes) {
        this.commandes = commandes;
    }*/
}
