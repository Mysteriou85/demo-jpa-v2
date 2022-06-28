package fr.diginamic;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "operation")
public class Operation {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqOperation")
    @GenericGenerator(name = "seqOperation", strategy = "increment")
    private Integer id;

    @Column(name = "DATE", nullable = false)
    private LocalDateTime date;

    @Column(name = "MONTANT", nullable = false)
    private Double montant;

    @Column(name = "MOTIF", length = 50)
    private String motif;

    @ManyToOne
    @JoinColumn(name = "ID_COMPTE")
    private Compte compte;

}
