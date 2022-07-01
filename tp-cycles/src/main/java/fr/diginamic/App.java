package fr.diginamic;

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

public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demo-jpa");
        EntityManager em = entityManagerFactory.createEntityManager();

        CycleDAO dao = new CycleDAO(em);

    }
}
