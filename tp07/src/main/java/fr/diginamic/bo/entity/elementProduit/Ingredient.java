package fr.diginamic.bo.entity.elementProduit;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Ingredient {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqIngredient")
    @GenericGenerator(name = "seqIngredient", strategy = "increment")
    private Integer id;
    private String libelle;

}
