package fr.diginamic;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    @GenericGenerator(name = "seq", strategy = "increment")
    private int id;

    @OneToMany(mappedBy="client")
    private Set<Emprunt> lesEmprunts;

//    @ManyToMany
//    @JoinTable(name= "COMPO",
//            joinColumns = @JoinColumn(name = "ID_CLIENT", referencedColumnName = "ID"),
//            inverseJoinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID"))
//    private Set<Emprunt> lesEmprunts;

    @Column(name = "NOM", length = 50, nullable = false)
    private String nom;

    @Column(name = "PRENOM", length = 50, nullable = false)
    private String prenom;



}
