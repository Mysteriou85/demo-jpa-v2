package fr.diginamic.bo.entity.cycle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "gyroroue")
public class Gyroroue extends Cycle {

    @Column(name = "AUTONOMIE")
    private double automonie;

    // Constructor

    public Gyroroue() {
    }

    public Gyroroue(String marque, String modele, LocalDate dataAchat, double automonie) {
        super(marque, modele, dataAchat);
        this.automonie = automonie;
    }


    // Getter & Setter

    public double getAutomonie() {
        return automonie;
    }

    public void setAutomonie(double automonie) {
        this.automonie = automonie;
    }

    // Methode
    @Override
    public double getTarifLocation() {
        return 18.9;
    }
}
