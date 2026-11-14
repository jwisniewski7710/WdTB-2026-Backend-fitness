package pl.wsb.fitness.schedule.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import pl.wsb.fitness.trainer.entity.Trainer;

import java.time.LocalDateTime;

/** Zajęcia w grafiku klubu: termin, sala, limit miejsc i trener, który je prowadzi. */
@Entity
@Table(name = "fitness_class")
public class FitnessClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 60)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false, length = 20)
    private ClassCategory category;

    @Column(name = "starts_at", nullable = false)
    private LocalDateTime startsAt;

    @Column(name = "duration_minutes", nullable = false)
    private Integer durationMinutes;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;               // limit miejsc na zajęciach

    @Column(name = "room", nullable = false, length = 40)
    private String room;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "trainer_id", nullable = false)
    private Trainer trainer;                // kto prowadzi zajęcia: wiele zajęć, jeden trener

    protected FitnessClass() {
    }

    public FitnessClass(String name, ClassCategory category, LocalDateTime startsAt, Integer durationMinutes,
                        Integer capacity, String room, Trainer trainer) {
        this.name = name;
        this.category = category;
        this.startsAt = startsAt;
        this.durationMinutes = durationMinutes;
        this.capacity = capacity;
        this.room = room;
        this.trainer = trainer;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ClassCategory getCategory() {
        return category;
    }

    public LocalDateTime getStartsAt() {
        return startsAt;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public String getRoom() {
        return room;
    }

    public Trainer getTrainer() {
        return trainer;
    }
}
