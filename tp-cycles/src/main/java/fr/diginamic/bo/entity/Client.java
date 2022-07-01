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
    private double portefeuille = 0d;

    // Constructor
    public Client() {
    }

    public Client(String nom, String prenom, double taille, double portefeuille) {
        this.nom = nom;
        this.prenom = prenom;
        this.taille = taille;
        this.portefeuille = portefeuille;
    }

    // Getter & Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public double getTaille() {
        return taille;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }

    public double getPortefeuille() {
        return portefeuille;
    }

    public void setPortefeuille(double portefeuille) {
        this.portefeuille = portefeuille;
    }
}
