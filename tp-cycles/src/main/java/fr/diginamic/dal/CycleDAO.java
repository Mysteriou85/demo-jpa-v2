package fr.diginamic.dal;

import fr.diginamic.bo.entity.cycle.Gyropode;
import fr.diginamic.bo.entity.cycle.Gyroroue;
import fr.diginamic.bo.entity.cycle.Velo;

import javax.persistence.EntityManager;

public class CycleDAO {

    private final EntityManager em;

    public CycleDAO(EntityManager em) {
        this.em = em;
    }

    public void createVelo (Velo velo) {
        em.getTransaction().begin();
        em.persist(velo);
        em.getTransaction().commit();
    }

    public void createGyropode (Gyropode gyropode) {
        em.getTransaction().begin();
        em.persist(gyropode);
        em.getTransaction().commit();
    }

    public void createGyroroue (Gyroroue gyroroue) {
        em.getTransaction().begin();
        em.persist(gyroroue);
        em.getTransaction().commit();
    }

}
