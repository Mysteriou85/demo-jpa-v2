package fr.diginamic.bo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cycle")
public abstract class Cycle {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqAdditif")
    @GenericGenerator(name = "seqAdditif", strategy = "increment")
    private Integer id;

    @Column(name = "MARQUE")
    private String marque;
    @Column(name = "MODELE")
    private String modele;
    @Column(name = "DATA_ACHAT")
    private LocalDate dataAchat;



}
