package org.example;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "planet")
public class Planet {
    @Id
    @Column(length = 10)
    private String id;

    @Column(nullable = false, length = 500)
    private String name;

    @OneToMany(mappedBy = "fromPlanet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> departureTickets;

    @OneToMany(mappedBy = "toPlanet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> arrivalTickets;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ticket> getDepartureTickets() {
        return departureTickets;
    }

    public void setDepartureTickets(List<Ticket> departureTickets) {
        this.departureTickets = departureTickets;
    }

    public List<Ticket> getArrivalTickets() {
        return arrivalTickets;
    }

    public void setArrivalTickets(List<Ticket> arrivalTickets) {
        this.arrivalTickets = arrivalTickets;
    }
}