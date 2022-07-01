package fr.diginamic.dal;

import fr.diginamic.bo.entity.Client;
import fr.diginamic.bo.entity.Location;
import fr.diginamic.bo.entity.PeriodeLocation;
import fr.diginamic.bo.entity.cycle.Cycle;
import fr.diginamic.bo.entity.cycle.Gyropode;
import fr.diginamic.bo.entity.cycle.Gyroroue;
import fr.diginamic.bo.entity.cycle.Velo;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CycleDAO {

    private final EntityManager em;

    public CycleDAO(EntityManager em) {
        this.em = em;
    }

    public void createCycle (Cycle cycle) {
        em.getTransaction().begin();
        em.persist(cycle);
        em.getTransaction().commit();
    }

    public void updateCycle (Cycle cycle) {
        em.getTransaction().begin();
        em.merge(cycle);
        em.getTransaction().commit();
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

    public List<Cycle> showCycleByOrderByMarque() {
        TypedQuery<Cycle> query = em.createQuery("SELECT e FROM Cycle e ORDER BY marque ASC", Cycle.class);
        return query.getResultList();
    }

    public void createLocation(Location location) {
        em.getTransaction().begin();
        em.merge(location);
        em.getTransaction().commit();
    }

    public void updateClient(Client client) {
        em.getTransaction().begin();
        em.merge(client);
        em.getTransaction().commit();
    }

    public List<PeriodeLocation> findPeriodesLocations(Cycle cycle) {
        List<PeriodeLocation> periodesLocations;
        TypedQuery<PeriodeLocation> query = em.createQuery("" +
                "Select periodeLocation " +
                "FROM Location l " +
                "JOIN l.cycles cycles " +
                "JOIN l.periodeLocation periodeLocation " +
                "WHERE cycles.id = :cycleId", PeriodeLocation.class);
        query.setParameter("cycleId", cycle.getId());
        periodesLocations = query.getResultList();
        return periodesLocations;
    }

}
