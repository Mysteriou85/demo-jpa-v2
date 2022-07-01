package fr.diginamic.bo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "gyropode")
public class Gyropode extends Cycle {

    @Column(name = "AUTONOMIE")
    private double automonie;
    @Column(name = "TAILLE_MIN")
    private double tailleMin;


}
