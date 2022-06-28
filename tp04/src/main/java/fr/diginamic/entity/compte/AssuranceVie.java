package fr.diginamic.entity.compte;

import fr.diginamic.entity.Client;
import fr.diginamic.entity.operation.Operation;

import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
public class AssuranceVie extends Compte {

    private LocalDateTime dateFin;
    private double taux;

    public AssuranceVie(String numero, Double solde, List<Client> clients, Set<Operation> operations, LocalDateTime dateFin, double taux) {
        super(numero, solde, clients, operations);
        this.dateFin = dateFin;
        this.taux = taux;
    }

    // Getter & Setter
    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
}
