# Schemat bazy danych

Plik generują reguły projektu (panel Maven → Lifecycle → verify). Nie edytujcie go ręcznie.

Tabele: 6 · kolumny: 40 · relacje: 4 × @ManyToOne, 1 × @OneToMany, 1 × @OneToOne, 0 × @ManyToMany

| Tabela | Encja | Kolumny | Klucze obce |
|---|---|---|---|
| class_booking | ClassBooking | 5 | club_member_id, fitness_class_id |
| club_member | ClubMember | 10 | user_account_id |
| fitness_class | FitnessClass | 8 | room_id, trainer_id |
| room | Room | 5 | — |
| trainer | Trainer | 7 | — |
| user_account | UserAccount | 5 | — |

```mermaid
erDiagram
    class_booking {
        Long id PK
        LocalDateTime booked_at
        Long club_member_id FK
        Long fitness_class_id FK
        BookingStatus status
    }
    club_member {
        Long id PK
        String city
        String first_name
        LocalDate joined_on
        String last_name
        MembershipType membership_type
        String phone
        String postal_code
        String street
        Long user_account_id FK
    }
    fitness_class {
        Long id PK
        Integer capacity
        ClassCategory category
        Integer duration_minutes
        String name
        Long room_id FK
        LocalDateTime starts_at
        Long trainer_id FK
    }
    room {
        Long id PK
        Boolean air_conditioned
        Integer floor
        Integer max_people
        String name
    }
    trainer {
        Long id PK
        Boolean active
        String email
        String first_name
        BigDecimal hourly_rate
        String last_name
        String specialization
    }
    user_account {
        Long id PK
        LocalDateTime created_at
        String display_name
        String email
        AccountRole role
    }
    club_member ||--o{ class_booking : "club_member_id"
    fitness_class ||--o{ class_booking : "fitness_class_id"
    room ||--o{ fitness_class : "room_id"
    trainer ||--o{ fitness_class : "trainer_id"
    user_account |o--o| club_member : "user_account_id"
```
