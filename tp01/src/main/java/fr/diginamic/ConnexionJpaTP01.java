package fr.diginamic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnexionJpaTP01 {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demo-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        ElementChimique elementChimique = entityManager.find(ElementChimique.class, 3);
        System.out.println(elementChimique.toString());

        // ajouté un nouveau élément
        ElementChimique newElementChimique = new ElementChimique();
        newElementChimique.setElNom("speliatium");
        newElementChimique.setElSymbole("Spe");
        newElementChimique.setElNumAtomique(66);
        newElementChimique.setElMasseAtomique(5.55f);

        entityManager.persist(newElementChimique);
        entityManager.getTransaction().commit();
        System.out.println(newElementChimique.getElId());

    }
}