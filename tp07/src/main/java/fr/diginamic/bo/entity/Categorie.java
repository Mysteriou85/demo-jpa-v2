package fr.diginamic.bo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "categorie")
public class Categorie {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqCategorie")
    @GenericGenerator(name = "seqCategorie", strategy = "increment")
    private Integer id;

    @Column(name = "LIBELLE", length = 510)
    private String libelle;

    @Column
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Set<Produit> produits;

    public Categorie() {
    }

    public Categorie(String libelle) {
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
