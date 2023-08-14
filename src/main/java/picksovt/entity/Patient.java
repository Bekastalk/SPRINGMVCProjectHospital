package picksovt.entity;


import jakarta.persistence.*;
import picksovt.enums.Gender;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_gen")
    @SequenceGenerator(name = "patient_gen", sequenceName = "patient_seq", allocationSize = 1)
    private Long id;
    private String firstName;
    private String lastName;
    @Pattern(regexp = "^(?!\\+996)\\d+$", message = "Phone number must not start with +996")
    private String phoneNumber;
    @Email
    private String email;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @ManyToOne
    private Hospital hospital;
    @OneToMany(mappedBy = "appointments")
    private List<Appointment> appointments;

}

