package peaksoft.entity;

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
    private String image;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
    private List<Department> departments;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
    private List<Patient> patients;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
    private List<Doctor> doctors;

    public void addDep(Department department) {
        if (departments == null) {
            departments = new ArrayList<>();
        } else {
            departments.add(department);
        }
    }

    public void addDoc(Doctor doctor) {
        if (doctors == null) {
            doctors = new ArrayList<>();
        } else {
            doctors.add(doctor);
        }
    }

    public void addPat(Patient patient) {
        if (patients == null) {
            patients = new ArrayList<>();
        } else {
            patients.add(patient);
        }
    }

    public void addApp(Appointment appointment) {
        if (appointments == null) {
            appointments = new ArrayList<>();
        } else {
            appointments.add(appointment);
        }
    }
}

