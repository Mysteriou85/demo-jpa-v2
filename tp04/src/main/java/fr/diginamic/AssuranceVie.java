package fr.diginamic;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class AssuranceVie extends Compte {

    private LocalDateTime dateFin;
    private double taux;

}
