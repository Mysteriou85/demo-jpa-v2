package fr.diginamic;

import fr.diginamic.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConnexionJpaTP04 {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demo-jpa");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        // Création d'une nouvelle adresse
        Adresse nouvelleAdresse = new Adresse();
        nouvelleAdresse.setNumero(26);
        nouvelleAdresse.setRue("Rue de Pierre");
        nouvelleAdresse.setCodePostal(85400);
        nouvelleAdresse.setVille("Nulpart");

        // Création d'un nouveau client
        Client nouveauClient = new Client();
        nouveauClient.setNom("Guy");
        nouveauClient.setPrenom("George");
        nouveauClient.setDateNaissance(LocalDate.of(1990, 02, 12));
        nouveauClient.setAdresse(nouvelleAdresse);

        // Création d'une nouvelle banque
        Banque nouvelleBanque = new Banque();
        nouvelleBanque.setNom("Banquepasterrible");
        nouveauClient.setBanque(nouvelleBanque);

        Set<Client> clientSet = new HashSet<>();
        clientSet.add(nouveauClient);

        nouvelleBanque.setClients(clientSet);

        // Création d'un nouveau compte
        Compte nouveauCompte = new Compte();
        nouveauCompte.setNumero("0004");
        nouveauCompte.setSolde(1500d);

        List<Client> clientList = new ArrayList<>();

        nouveauCompte.setClients(clientList);

        // Création d'un compte avec deux individus
        Compte nouveauCompteADeux = new Compte();
        nouveauCompteADeux.setNumero("0005");
        nouveauCompteADeux.setSolde(5000d);

        List<Client> clientList2 = new ArrayList<>();
        Client selectClient1 = em.find(Client.class, 1);
        Client selectClient2 = em.find(Client.class, 2);
        clientList2.add(selectClient1);
        clientList2.add(selectClient2);

        nouveauCompteADeux.setClients(clientList2);

        //em.persist(nouveauCompteADeux);

        // Création d'une nouvelle opération
        Operation nouvelleOperation = new Operation();
        nouvelleOperation.setDate(LocalDate.of(2020, 1, 10));
        nouvelleOperation.setMontant(1000d);
        nouvelleOperation.setMotif("Pourquoipas");
        nouvelleOperation.setCompte(nouveauCompte);

//        em.persist(nouveauClient);
//        em.persist(nouveauCompte);
//        em.persist(nouvelleBanque);
//        em.persist(nouvelleOperation);
//        nouveauClient = em.merge(nouveauClient);

        em.getTransaction().commit();
    }
}
