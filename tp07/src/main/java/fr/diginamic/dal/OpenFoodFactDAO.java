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
        TypedQuery<Categorie> query = em.createQuery("SELECT e FROM Categorie e WHERE e.libelle = :libelle", Categorie.class);
        query.setParameter("libelle", libelle);
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null;
    }

    public Marque getMarque(String libelle) {
        TypedQuery<Marque> query = em.createQuery("SELECT e FROM Marque e WHERE e.libelle = :libelle", Marque.class);
        query.setParameter("libelle", libelle);
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null;
    }

    public Ingredient getIngredient(String libelle) {
        TypedQuery<Ingredient> query = em.createQuery("SELECT e FROM Ingredient e WHERE e.libelle = :libelle", Ingredient.class);
        query.setParameter("libelle", libelle);
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null;
    }

    public Allergene getAllergene(String libelle) {
        TypedQuery<Allergene> query = em.createQuery("SELECT e FROM Allergene e WHERE e.libelle = :libelle", Allergene.class);
        query.setParameter("libelle", libelle);
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null;
    }

    public Additif getAdditif(String libelle) {
        TypedQuery<Additif> query = em.createQuery("SELECT e FROM Additif e WHERE e.libelle = :libelle", Additif.class);
        query.setParameter("libelle", libelle);
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null;
    }


}
