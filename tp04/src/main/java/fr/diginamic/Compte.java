package fr.diginamic;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "compte")
public class Compte {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqCompte")
    @GenericGenerator(name = "seqCompte", strategy = "increment")
    private Integer id;

    @Column(name = "NUMERO", nullable = false)
    private String numero;

    @Column(name = "SOLDE", nullable = false)
    private Double solde;

    @ManyToMany(mappedBy = "comptes")
    private List<Client> clients;

    @Column
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Set<Operation> operations;

}
