package fr.diginamic.bo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "gyroroue")
public class Gyroroue extends Cycle {

    @Column(name = "AUTONOMIE")
    private double automonie;

}
