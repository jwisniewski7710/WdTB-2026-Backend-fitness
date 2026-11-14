package pl.wsb.fitness.trainer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import pl.wsb.fitness.schedule.entity.FitnessClass;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/** Trener prowadzący zajęcia w klubie. Lista jego zajęć to druga strona relacji z FitnessClass. */
@Entity
@Table(name = "trainer")
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 40)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 60)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true, length = 120)
    private String email;

    @Column(name = "specialization", length = 80)
    private String specialization;

    @Column(name = "hourly_rate", nullable = false, precision = 10, scale = 2)
    private BigDecimal hourlyRate;

    @Column(name = "active", nullable = false)
    private Boolean active;                 // trener prowadzi teraz zajęcia

    @OneToMany(mappedBy = "trainer")        // zajęcia tego trenera; kolumna trainer_id jest w tabeli fitness_class
    private List<FitnessClass> classes = new ArrayList<>();

    protected Trainer() {
    }

    public Trainer(String firstName, String lastName, String email, String specialization,
                   BigDecimal hourlyRate, Boolean active) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.specialization = specialization;
        this.hourlyRate = hourlyRate;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getSpecialization() {
        return specialization;
    }

    public BigDecimal getHourlyRate() {
        return hourlyRate;
    }

    public Boolean getActive() {
        return active;
    }

    public List<FitnessClass> getClasses() {
        return classes;
    }
}
