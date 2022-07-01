package fr.diginamic.bll;

import fr.diginamic.bll.exception.APiedCestBienAussiException;
import fr.diginamic.bll.exception.CycleIndisponibleException;
import fr.diginamic.bo.entity.Client;
import fr.diginamic.bo.entity.Location;
import fr.diginamic.bo.entity.PeriodeLocation;
import fr.diginamic.bo.entity.cycle.Cycle;
import fr.diginamic.dal.CycleDAO;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
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

    public Double calculerTarifLocation(Set<Cycle> cycles, LocalDateTime dateDebut, LocalDateTime dateFin) {

        double total = 0;
        for (Cycle cycle : cycles) {
            total += calculerTarifLocation(cycle, dateDebut, dateFin);
        }

        return total;
    }

    public Double calculerTarifLocation(Cycle cycle, LocalDateTime dateDebut, LocalDateTime dateFin) {
        long nombreDHeures = Duration.between(dateDebut, dateFin).toHours();
        return cycle.getTarifLocation() * nombreDHeures;
    }

    public boolean isDisponibleALaLocation(Cycle cycle, LocalDateTime dateDebut, LocalDateTime dateFin) {
        List<PeriodeLocation> periodesLocations = cycleDao.findPeriodesLocations(cycle);
        return periodesLocations.stream().filter(e -> isOverlaying(e.getDateDebut(), e.getDateFin(), dateDebut, dateFin))
                .findAny()
                .isEmpty();
    }


    public boolean isOverlaying(LocalDateTime dateDebut, LocalDateTime dateFin, LocalDateTime dateDebut2, LocalDateTime dateFin2) {
        return ((dateDebut.isEqual(dateFin2) || dateDebut.isBefore(dateFin2)) &&
                (dateDebut.isEqual(dateDebut2) || dateDebut.isAfter(dateDebut2))) ||
                ((dateDebut.isEqual(dateFin2) || dateDebut.isBefore(dateFin2)) &&
                        (dateDebut.isEqual(dateDebut2) || dateDebut.isAfter(dateDebut2)));
    }


}
