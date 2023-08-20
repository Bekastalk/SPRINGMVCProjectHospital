package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Data;


import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_gen")
    @SequenceGenerator(name = "department_gen", sequenceName = "department_seq", allocationSize = 1)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(name = "department_doctor",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "doctor_id"))
    private List<Doctor> doctors;

    @ManyToOne
    private Hospital hospital;
    @OneToMany(mappedBy = "department")
    private List<Appointment> appointment;

    public void addDoc(Doctor doctor) {
        if(doctors==null){
            doctors=new ArrayList<>();
        }else doctors.add(doctor);
    }
}
