package fr.diginamic.dal;

import fr.diginamic.bo.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class OpenFoodFactDAO {

    private final EntityManager em;

    public OpenFoodFactDAO(EntityManager em) {
        this.em = em;
    }

    public void createProduit (Produit produit) {
        em.getTransaction().begin();
        em.persist(produit);
        em.getTransaction().commit();
    }

    public void createCategorie (Categorie categorie) {
        em.getTransaction().begin();
        em.persist(categorie);
        em.getTransaction().commit();
    }

    public void createMarque (Marque marque) {
        em.getTransaction().begin();
        em.persist(marque);
        em.getTransaction().commit();
    }

    public void createIngredient (Ingredient ingredient) {
        em.getTransaction().begin();
        em.persist(ingredient);
        em.getTransaction().commit();
    }

    public void createAllergene (Allergene allergene) {
        em.getTransaction().begin();
        em.persist(allergene);
        em.getTransaction().commit();
    }

    public void createAdditif (Additif additif) {
        em.getTransaction().begin();
        em.persist(additif);
        em.getTransaction().commit();
    }

    public Categorie getCategorie(String libelle) {
        TypedQuery<Categorie> query = em.createQuery("select e from Categorie e where e.libelle = :libelle", Categorie.class);
        query.setParameter("libelle", libelle);
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null;
    }


}
