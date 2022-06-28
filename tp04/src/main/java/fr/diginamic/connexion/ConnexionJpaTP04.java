package fr.diginamic.connexion;

import fr.diginamic.*;

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
        nouvelleAdresse.setNumero(15);
        nouvelleAdresse.setRue("Rue de George");
        nouvelleAdresse.setCodePostal(85400);
        nouvelleAdresse.setVille("Nulpart");

        // Création d'un nouveau client
        Client nouveauClient = new Client();
        nouveauClient.setNom("Guy");
        nouveauClient.setPrenom("George");
        nouveauClient.setDateNaissance(LocalDate.of(1990, 05, 25));
        nouveauClient.setAdresse(nouvelleAdresse);

        // Création d'une nouvelle banque
        Banque nouvelleBanque = new Banque();
        nouvelleBanque.setNom("Bancaterisque");
        nouveauClient.setBanque(nouvelleBanque);

        Set<Client> clientSet = new HashSet<>();
        clientSet.add(nouveauClient);

        nouvelleBanque.setClients(clientSet);

        // Création d'un nouveau compte
        Compte nouveauCompte = new Compte();
        nouveauCompte.setNumero("0001");
        nouveauCompte.setSolde(1000d);

        List<Client> clientList = new ArrayList<>();

        nouveauCompte.setClients(clientList);

        // Création d'une nouvelle opération
        Operation nouvelleOperation = new Operation();
        nouvelleOperation.setDate(LocalDate.of(2022, 06, 28));
        nouvelleOperation.setMontant(15d);
        nouvelleOperation.setMotif("Parceque");
        nouvelleOperation.setCompte(nouveauCompte);

        em.persist(nouveauClient);
        em.persist(nouveauCompte);
        em.persist(nouvelleBanque);
        em.persist(nouvelleOperation);
        //nouveauClient = em.merge(nouveauClient);

        em.getTransaction().commit();
    }
}
