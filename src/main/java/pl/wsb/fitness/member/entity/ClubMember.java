package pl.wsb.fitness.member.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

/** Klubowicz: osoba, która zapisuje się na zajęcia. Powiązanie z kontem logowania (UserAccount) dojdzie na kolejnych zajęciach. */
@Entity
@Table(name = "club_member")
public class ClubMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 40)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 60)
    private String lastName;

    @Column(name = "phone", length = 20)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "membership_type", nullable = false, length = 20)
    private MembershipType membershipType;

    @Column(name = "joined_on", nullable = false)
    private LocalDate joinedOn;

    @Embedded
    private Address address;                // klasa wbudowana: ulica, miasto, kod pocztowy

    protected ClubMember() {
    }

    public ClubMember(String firstName, String lastName, String phone, MembershipType membershipType,
                      LocalDate joinedOn, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.membershipType = membershipType;
        this.joinedOn = joinedOn;
        this.address = address;
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

    public String getPhone() {
        return phone;
    }

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public LocalDate getJoinedOn() {
        return joinedOn;
    }

    public Address getAddress() {
        return address;
    }
}
