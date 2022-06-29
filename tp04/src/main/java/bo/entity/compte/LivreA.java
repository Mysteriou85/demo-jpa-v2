package bo.entity.compte;

import bo.entity.Client;
import bo.entity.operation.Operation;

import javax.persistence.Entity;
import java.util.List;
import java.util.Set;

@Entity
public class LivreA extends Compte {

    private double taux;

    // Constructor
    public LivreA(String numero, Double solde, List<Client> clients, Set<Operation> operations, double taux) {
        super(numero, solde, clients, operations);
        this.taux = taux;
    }

    // Getter & Setter
    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
}
