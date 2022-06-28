package fr.diginamic;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "banque")
public class Banque {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqBanque")
    @GenericGenerator(name = "seqBanque", strategy = "increment")
    private Integer id;

    @Column(name = "NOM", length = 50, nullable = false)
    private String nom;

    @Column
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Set<Client> clients;

    // Constructor
    public Banque() {

    }

    public Banque(String nom, Set<Client> clients) {
        this.nom = nom;
        this.clients = clients;
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

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }
}
