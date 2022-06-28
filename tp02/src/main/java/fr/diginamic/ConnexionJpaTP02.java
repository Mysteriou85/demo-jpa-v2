package fr.diginamic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;

public class ConnexionJpaTP02 {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demo-jpa");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

//        Livre livre = em.find(Livre.class, 3);
//        System.out.println(livre.toString());

        // TP 02
//        Livre newLivre = new Livre();
//        newLivre.setAuteur("auteur");
//        newLivre.setTitre("le titre");
//        em.persist(livre);

//        Client client = em.find(Client.class, 1);
//        if (client != null) {
//            Emprunt emprunt = new Emprunt(
//                    LocalDateTime.now(),
//                    LocalDateTime.now().plusWeeks(2L),
//                    10,
//                    client
//            );
//            em.persist(emprunt);
//        }

        // Exo : Réaliser une requête qui permet d'extraire un emprunt en fonction de son id
        Emprunt emprunt = em.find(Emprunt.class, 1);

        // Exo : Affichez tous les livres associés
        System.out.println("    Livres associés à l'emprunt 1 :");
        emprunt.getLivres().forEach(System.out::println);

        // Exo : Réaliser une requête qui permet d'extraire tous les emprunts d'un cleint donné
        System.out.println("    Emprunts du client 1 :");
        TypedQuery<Emprunt> empruntsDunClient = em.createQuery("select e from Emprunt e where client=:id", Emprunt.class);
        Client toFind = new Client();
        toFind.setId(1);
        empruntsDunClient.setParameter("id", toFind);
        List<Emprunt> emprunts = empruntsDunClient.getResultList();
        emprunts.forEach(System.out::println);

        // Exo : Lister les emprunts d'un clients vavec la relation @oneToMany depuis Client vers Emprunt
        System.out.println("    Liste emprunts du client 1 :");
        Client client1 = em.find(Client.class, 1);

        Emprunt newEmprunt = new Emprunt(
                LocalDateTime.now(),
                LocalDateTime.now().plusWeeks(2L),
                10,
                client1
        );

        client1.getEmprunts().add(newEmprunt);
        // em.persist(newEmprunt);

        client1 = em.merge(client1);

        //client1.getEmprunts().add(new Emprunt());
        client1.getEmprunts().forEach(System.out::println);


        em.getTransaction().commit();
    }
}
