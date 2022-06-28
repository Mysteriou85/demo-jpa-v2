package fr.diginamic;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Embeddable
public class Adresse {

    private Integer numero;
    private String rue;
    private Integer codePostal;
    private String ville;

}
