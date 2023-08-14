package picksovt.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "hospitals")
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hospital_gen")
    @SequenceGenerator(name = "hospital_gen", sequenceName = "hospital_seq", allocationSize = 1)
    private Long id;

    private String name;

    private String address;

    @OneToMany(mappedBy = "hospitals", cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private List<Department> departments;

    @OneToMany(mappedBy = "hospitals", cascade = CascadeType.ALL)
    @JoinColumn(name = "appointment_id")
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "hospitals", cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private List<Patient> patients;

    @OneToMany(mappedBy = "hospitals")
    @JoinColumn(name = "doctor_id")
    private List<Doctor> doctors;
}
