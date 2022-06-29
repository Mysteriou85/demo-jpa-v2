package fr.diginamic.bo.entity.elementProduit;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Allergene {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqAllergene")
    @GenericGenerator(name = "seqAllergene", strategy = "increment")
    private Integer id;
    private String libelle;

}
