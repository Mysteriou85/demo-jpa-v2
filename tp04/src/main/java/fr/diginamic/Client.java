package fr.diginamic;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    private LocalDateTime dateNaissance;

    @Embedded
    private Adresse adresse;

    @ManyToOne
    @JoinColumn(name = "ID_BANQUE")
    private Banque banque;

    @ManyToMany
    @JoinTable(name = "LIEN_CLIENT_COMPTE",
            joinColumns = @JoinColumn(name = "ID_CLIENT", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_COMPTE", referencedColumnName = "ID"))
    private List<Compte> comptes;
}
