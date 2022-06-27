package fr.diginamic;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "elements_chimiques")
public class ElementChimique {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    @GenericGenerator(name = "seq", strategy = "increment")
    private int elId;

    @Column(name = "elNom", length = 50)
    private String elNom;

    @Column(name = "elSymbole", length = 3)
    private String elSymbole;

    @Column(name = "elNumAtomique")
    private int elNumAtomique;

    @Column(name = "elMasseAtomique")
    private float elMasseAtomique;

    // Constructor
    public ElementChimique() {

    }

    // Getter
    public long getElId() {
        return elId;
    }

    public String getElNom() {
        return elNom;
    }

    public String getElSymbole() {
        return elSymbole;
    }

    public int getElNumAtomique() {
        return elNumAtomique;
    }

    public float getElMasseAtomique() {
        return elMasseAtomique;
    }

    // Setter
    public void setElId(int elId) {
        this.elId = elId;
    }

    public void setElNom(String elNom) {
        this.elNom = elNom;
    }

    public void setElSymbole(String elSymbole) {
        this.elSymbole = elSymbole;
    }

    public void setElNumAtomique(int elNumAtomique) {
        this.elNumAtomique = elNumAtomique;
    }

    public void setElMasseAtomique(float elMasseAtomique) {
        this.elMasseAtomique = elMasseAtomique;
    }

    // Methode

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ElementChimique [");
        sb.append("elId = ").append(elId);
        sb.append(", elNom = '").append(elNom).append('\'');
        sb.append(", elSymbole = '").append(elSymbole).append('\'');
        sb.append(", elNumAtomique = ").append(elNumAtomique);
        sb.append(", elMasseAtomique = ").append(elMasseAtomique);
        sb.append('}');
        return sb.toString();
    }
}