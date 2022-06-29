package fr.diginamic.bo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "allergene")
public class Allergene {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqAllergene")
    @GenericGenerator(name = "seqAllergene", strategy = "increment")
    private Integer id;

    @Column(name = "LIBELLE")
    private String libelle;

    @ManyToMany(mappedBy = "allergenes")
    private List<Produit> produits;

    public Allergene() {
    }

    public Allergene(String libelle) {
        this.libelle = libelle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
