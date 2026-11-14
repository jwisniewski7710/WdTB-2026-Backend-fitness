package pl.wsb.fitness.booking.entity;

/** Stan zapisu na zajęcia. W bazie zapisywany jako tekst (@Enumerated(EnumType.STRING)). */
public enum BookingStatus {
    BOOKED,
    CANCELLED,
    ATTENDED
}
