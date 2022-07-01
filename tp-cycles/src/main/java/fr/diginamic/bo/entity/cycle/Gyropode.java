package fr.diginamic.bo.entity.cycle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "gyropode")
public class Gyropode extends Cycle {

    @Column(name = "AUTONOMIE")
    private double automonie;
    @Column(name = "TAILLE_MIN")
    private double tailleMin;

    // Constructor

    public Gyropode() {
    }

    public Gyropode(String marque, String modele, LocalDate dataAchat, double automonie, double tailleMin) {
        super(marque, modele, dataAchat);
        this.automonie = automonie;
        this.tailleMin = tailleMin;
    }

    // Getter & Setter

    public double getAutomonie() {
        return automonie;
    }

    public void setAutomonie(double automonie) {
        this.automonie = automonie;
    }

    public double getTailleMin() {
        return tailleMin;
    }

    public void setTailleMin(double tailleMin) {
        this.tailleMin = tailleMin;
    }

    // Methode
    @Override
    public double getTarifLocation() {
        return 29.9;
    }
}
