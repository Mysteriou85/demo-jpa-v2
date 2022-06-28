package fr.diginamic.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "operation")
public class Operation {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqOperation")
    @GenericGenerator(name = "seqOperation", strategy = "increment")
    private Integer id;

    @Column(name = "DATE", nullable = false)
    private LocalDate date;

    @Column(name = "MONTANT", nullable = false)
    private Double montant;

    @Column(name = "MOTIF", length = 50)
    private String motif;

    @ManyToOne
    @JoinColumn(name = "ID_COMPTE")
    private Compte compte;

    // Constructor
    public Operation() {
    }

    public Operation(LocalDate date, Double montant, String motif, Compte compte) {
        this.date = date;
        this.montant = montant;
        this.motif = motif;
        this.compte = compte;
    }

    // Getter & Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}
