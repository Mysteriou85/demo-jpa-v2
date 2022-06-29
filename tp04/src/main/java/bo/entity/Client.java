package bo.entity;

import bo.entity.compte.Compte;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqClient")
    @GenericGenerator(name = "seqClient", strategy = "increment")
    private Integer id;

    @Column(name = "NOM", length = 50, nullable = false)
    private String nom;

    @Column(name = "PRENOM", length = 50, nullable = false)
    private String prenom;

    @Column(name = "DATE_NAISSANCE", nullable = false)
    private LocalDate dateNaissance;

    @Embedded
    private Adresse adresse;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_BANQUE")
    private Banque banque;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
//    @JoinTable(name = "LIEN_CLIENT_COMPTE",
//            joinColumns = @JoinColumn(name = "ID_CLIENT", referencedColumnName = "ID"),
//            inverseJoinColumns = @JoinColumn(name = "ID_COMPTE", referencedColumnName = "ID"))
    private List<Compte> comptes;

    // Constructor
    public Client() {
    }

    public Client(String nom, String prenom, LocalDate dateNaissance, Adresse adresse, Banque banque, List<Compte> comptes) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.banque = banque;
        this.comptes = comptes;
    }

    // Getter & Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Banque getBanque() {
        return banque;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }
}
