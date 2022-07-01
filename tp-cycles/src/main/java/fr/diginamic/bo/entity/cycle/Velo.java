package fr.diginamic.bo.entity.cycle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "velo")
public class Velo extends Cycle {

    @Column(name = "NOMBRE_VITESSE")
    private int nombreVitesse;

    // Constructor

    public Velo() {
    }

    public Velo(String marque, String modele, LocalDate dataAchat, int nombreVitesse) {
        super(marque, modele, dataAchat);
        this.nombreVitesse = nombreVitesse;
    }

    // Getter & Setter

    public int getNombreVitesse() {
        return nombreVitesse;
    }

    public void setNombreVitesse(int nombreVitesse) {
        this.nombreVitesse = nombreVitesse;
    }

    // Methode
    @Override
    public double getTarifLocation() {
        return 4.9;
    }
}
