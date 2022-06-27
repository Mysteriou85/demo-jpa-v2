package fr.diginamic;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "livre")
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    @GenericGenerator(name = "seq", strategy = "increment")
    private int ID;

    @Column(name = "TITRE", nullable = false)
    private String TITRE;

    @Column(name = "AUTEUR", length = 50, nullable = false)
    private String AUTEUR;

    // Constructor
    public Livre() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTITRE() {
        return TITRE;
    }

    public void setTITRE(String TITRE) {
        this.TITRE = TITRE;
    }

    public String getAUTEUR() {
        return AUTEUR;
    }

    public void setAUTEUR(String AUTEUR) {
        this.AUTEUR = AUTEUR;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Livre [");
        sb.append("ID = ").append(ID);
        sb.append(", TITRE = '").append(TITRE).append('\'');
        sb.append(", AUTEUR = '").append(AUTEUR).append('\'');
        sb.append(']');
        return sb.toString();
    }
}
