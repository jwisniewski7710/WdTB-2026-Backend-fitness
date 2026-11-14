package pl.wsb.fitness.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.fitness.booking.entity.ClassBooking;

import java.util.List;

/** Zapisy na zajęcia w bazie. Spring Data buduje zapytania SQL z nazw metod. */
public interface ClassBookingRepository extends JpaRepository<ClassBooking, Long> {

    /** Lista zapisów na zajęcia o podanej nazwie, np. „Poranna joga”: zapytanie idzie przez relację fitnessClass. */
    List<ClassBooking> findByFitnessClass_Name(String name);
}
