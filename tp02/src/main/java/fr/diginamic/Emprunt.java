package fr.diginamic;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "emprunt")
public class Emprunt {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqEmprunt")
    @GenericGenerator(name = "seqEmprunt", strategy = "increment")
    private int id;

    @Column(name = "DATE_DEBUT", nullable = false)
    private LocalDateTime dateDebut;

    @Column(name = "DATE_FIN")
    private LocalDateTime dateFin;

    @Column(name = "DELAI")
    private int delai;

//    @ManyToOne
//    @JoinColumn(name = "")
//    @Column(name = "ID_CLIENT", nullable = false)
//    private int idClient;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENT")
    private Client client;

    @ManyToMany
    @JoinTable(name = "COMPO",
        joinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID"),
        inverseJoinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID"))
    private List<Livre> livres;

    // Constructor
    public Emprunt() {
    }

    public Emprunt(LocalDateTime dateDebut, LocalDateTime dateFin, int delai, Client client) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.delai = delai;
        this.client = client;
    }

    // Getter & Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    public int getDelai() {
        return delai;
    }

    public void setDelai(int delai) {
        this.delai = delai;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Livre> getLivres() {
        return livres;
    }

    public void setLivres(List<Livre> livres) {
        this.livres = livres;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Emprunt [");
//        sb.append("id = ").append(id);
        sb.append(", dateDebut = ").append(dateDebut);
        sb.append(", dateFin = ").append(dateFin);
        sb.append(", delai = ").append(delai);
        sb.append(", client = ").append(client);
        sb.append(", livres = ").append(livres);
//        sb.append(", livres = ").append(livres.stream().map(Livre::getId).toList());
        sb.append(']');
        return sb.toString();
    }
}
