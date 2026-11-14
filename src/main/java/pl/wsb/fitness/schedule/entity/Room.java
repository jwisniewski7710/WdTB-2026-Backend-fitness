package pl.wsb.fitness.schedule.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/** Sala w klubie, w której odbywają się zajęcia z grafiku. */
@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true, length = 40)
    private String name;

    @Column(name = "floor", nullable = false)
    private Integer floor;

    @Column(name = "max_people", nullable = false)
    private Integer maxPeople;              // ile osób mieści sala

    @Column(name = "air_conditioned", nullable = false)
    private Boolean airConditioned;

    protected Room() {
    }

    public Room(String name, Integer floor, Integer maxPeople, Boolean airConditioned) {
        this.name = name;
        this.floor = floor;
        this.maxPeople = maxPeople;
        this.airConditioned = airConditioned;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getFloor() {
        return floor;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public Boolean getAirConditioned() {
        return airConditioned;
    }
}
