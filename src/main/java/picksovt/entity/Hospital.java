package picksovt.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
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
    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
    @JoinColumn(name="department_id")
    private List<Department> departments;
    @OneToMany(mappedBy = "hospital")
    @JoinColumn(name = "appointment_id")

    private List<Appointment> appointments;
    @OneToMany(mappedBy = "patient")
    @JoinColumn(name = "depatient_id")

    private List<Patient> patients;
    @OneToMany
    @JoinColumn(name = "doctor_id")
    private List<Doctor> doctors;
}
