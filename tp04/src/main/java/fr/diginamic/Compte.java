package fr.diginamic;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "compte")
public class Compte {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqCompte")
    @GenericGenerator(name = "seqCompte", strategy = "increment")
    private Integer id;

    @Column(name = "NUMERO", nullable = false, unique = true)
    private String numero;

    @Column(name = "SOLDE", nullable = false)
    private Double solde;

    @ManyToMany(mappedBy = "comptes")
    private List<Client> clients;

    @Column
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Set<Operation> operations;

    // Constructor
    public Compte() {
    }

    public Compte(String numero, Double solde, List<Client> clients, Set<Operation> operations) {
        this.numero = numero;
        this.solde = solde;
        this.clients = clients;
        this.operations = operations;
    }

    // Getter & Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Set<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }
}
