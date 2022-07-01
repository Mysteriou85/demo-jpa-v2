package fr.diginamic.bll;

import fr.diginamic.bo.entity.Client;
import fr.diginamic.bo.entity.Location;
import fr.diginamic.bo.entity.PeriodeLocation;
import fr.diginamic.bo.entity.cycle.Cycle;
import fr.diginamic.dal.CycleDAO;

import java.time.LocalDateTime;
import java.util.Set;

public class ServiceCycle {

    private CycleDAO cycleDao;

    public ServiceCycle(CycleDAO cycleDao) {
        this.cycleDao = cycleDao;
    }

    public void ajouterCycle(Cycle cycle) {
        cycleDao.createCycle(cycle);
    }

    public void louer(Client client, Set<Cycle> cycles, LocalDateTime dateDebut, LocalDateTime dateFin) throws CycleIndisponibleException, APiedCestBienAussiException {

        for (Cycle cycle : cycles) {
            if (!isDisponibleALaLocation(cycle, dateDebut, dateFin)) {
                throw new CycleIndisponibleException("Le cycle est déjà loué pour cette période");
            }
        }

        double tarifs = calculerTarifLocation(cycles, dateDebut, dateFin);
        if (tarifs > client.getPortefeuille()) {
            throw new APiedCestBienAussiException("Le magasin ne fait pas crédit!");
        }

        Location nouvelleLocation = new Location(client, cycles, new PeriodeLocation(dateDebut, dateFin));
        cycleDao.createLocation(nouvelleLocation);
        client.setPortefeuille(client.getPortefeuille() - tarifs);
        cycleDao.updateClient(client);
    }


}
