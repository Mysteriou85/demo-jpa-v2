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

}
