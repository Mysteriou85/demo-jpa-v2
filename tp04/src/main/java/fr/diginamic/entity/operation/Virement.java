package fr.diginamic.entity.operation;

import fr.diginamic.entity.compte.Compte;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Virement extends Operation {

    private String beneficiaire;

    // Constructor
    public Virement(LocalDate date, Double montant, String motif, Compte compte, String beneficiaire) {
        super(date, montant, motif, compte);
        this.beneficiaire = beneficiaire;
    }

    // Getter & Setter
    public String getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }
}
