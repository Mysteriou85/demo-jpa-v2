package fr.diginamic.bo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "velo")
public class Velo extends Cycle {

    @Column(name = "NOMBRE_VITESSE")
    private int nombreVitesse;
}
