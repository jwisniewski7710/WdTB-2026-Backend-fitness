package pl.wsb.fitness.booking.entity;

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
import pl.wsb.fitness.member.entity.ClubMember;
import pl.wsb.fitness.schedule.entity.FitnessClass;

import java.time.LocalDateTime;

/** Zapis klubowicza na zajęcia: tabela łącząca klubowiczów i zajęcia (wiele-do-wielu) z datą i stanem zapisu. */
@Entity
@Table(name = "class_booking")
public class ClassBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "club_member_id", nullable = false)
    private ClubMember member;              // kto się zapisał

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fitness_class_id", nullable = false)
    private FitnessClass fitnessClass;      // na które zajęcia

    @Column(name = "booked_at", nullable = false)
    private LocalDateTime bookedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private BookingStatus status;           // zapisany, zrezygnował albo był na zajęciach

    protected ClassBooking() {
    }

    public ClassBooking(ClubMember member, FitnessClass fitnessClass, LocalDateTime bookedAt, BookingStatus status) {
        this.member = member;
        this.fitnessClass = fitnessClass;
        this.bookedAt = bookedAt;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public ClubMember getMember() {
        return member;
    }

    public FitnessClass getFitnessClass() {
        return fitnessClass;
    }

    public LocalDateTime getBookedAt() {
        return bookedAt;
    }

    public BookingStatus getStatus() {
        return status;
    }
}
