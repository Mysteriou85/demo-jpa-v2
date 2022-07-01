package fr.diginamic.bo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqAdditif")
    @GenericGenerator(name = "seqAdditif", strategy = "increment")
    private Integer id;

    private String nom;
    private String prenom;
    private double taille;
    private double portefeuille;

}
