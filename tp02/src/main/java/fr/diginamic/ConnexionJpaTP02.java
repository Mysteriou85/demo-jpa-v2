package fr.diginamic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnexionJpaTP02 {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demo-jpa");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        Livre livre = em.find(Livre.class, 3);
        System.out.println(livre.toString());


    }
}
