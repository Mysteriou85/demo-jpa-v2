package fr.diginamic.bo.entity;

import fr.diginamic.bo.entity.cycle.Cycle;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqAdditif")
    @GenericGenerator(name = "seqAdditif", strategy = "increment")
    private Integer id;

    public Location() {
    }

    public Location(Client client, Set<Cycle> cycles, PeriodeLocation periodeLocation) {
        this.client = client;
        this.cycles = cycles;
        this.periodeLocation = periodeLocation;
    }

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    private Set<Cycle> cycles;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "periode_location_id")
    private PeriodeLocation periodeLocation;

    public PeriodeLocation getPeriodeLocation() {
        return periodeLocation;
    }

    public void setPeriodeLocation(PeriodeLocation periodeLocation) {
        this.periodeLocation = periodeLocation;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
