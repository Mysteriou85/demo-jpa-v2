package fr.diginamic.dal;

import fr.diginamic.bo.entity.Produit;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAOFactory {
    public static EntityManagerFactory getFactory() {return Persistence.createEntityManagerFactory("demo-jpa");
    }
}
