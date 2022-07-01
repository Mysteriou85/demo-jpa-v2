package fr.diginamic.bo.entity.cycle;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
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

    // Constructor

    public Cycle() {
    }

    public Cycle(String marque, String modele, LocalDate dataAchat) {
        this.marque = marque;
        this.modele = modele;
        this.dataAchat = dataAchat;
    }

    // Getter & Setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public LocalDate getDataAchat() {
        return dataAchat;
    }

    public void setDataAchat(LocalDate dataAchat) {
        this.dataAchat = dataAchat;
    }

    // Methode
    public abstract double getTarifLocation();

}
