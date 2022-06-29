package fr.diginamic.bo.entity.elementProduit;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqIngredient")
    @GenericGenerator(name = "seqIngredient", strategy = "increment")
    private Integer id;

    @Column(name = "LIBELLE")
    private String libelle;

    public Ingredient() {
    }

    public Ingredient(String libelle) {
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
