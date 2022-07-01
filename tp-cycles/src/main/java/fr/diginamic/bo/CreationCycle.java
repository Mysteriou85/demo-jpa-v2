package fr.diginamic.bo;

import fr.diginamic.bo.entity.cycle.Cycle;
import fr.diginamic.bo.entity.cycle.Gyropode;
import fr.diginamic.bo.entity.cycle.Gyroroue;
import fr.diginamic.bo.entity.cycle.Velo;
import fr.diginamic.dal.CycleDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.Month;

public class CreationCycle {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demo-jpa");
        EntityManager em = entityManagerFactory.createEntityManager();

        CycleDAO dao = new CycleDAO(em);

        Cycle[] nouveauCycle = {
                new Velo("Marque", "modele v200", LocalDate.of(2019, Month.MARCH, 26), 25),
                new Gyropode("Marque", "modele v200", LocalDate.of(2019, Month.MARCH, 26), 15, 15),
                new Gyroroue("Marque", "modele v200", LocalDate.of(2019, Month.MARCH, 26), 15)
        };
        for (Cycle cycle : nouveauCycle) {
            System.out.printf(" %-95s %5.2fe/heure%n", cycle, cycle.getTarifLocation());
        }

        Velo velo1 = new Velo("Marque connu", "Module pas mal", LocalDate.now(), 10);
        dao.createVelo(velo1);
    }
}
