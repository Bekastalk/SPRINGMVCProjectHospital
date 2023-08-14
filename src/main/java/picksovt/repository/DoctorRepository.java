package picksovt.repository;

import picksovt.entity.Doctor;

import java.util.List;

public interface DoctorRepository {
    void saveDoctor(Doctor doctor);
    Doctor getDoctorById(Long id);
    List<Doctor> getAllDoctors();
    void updateDoctor(Long id, Doctor updatedDoctor);
    void deleteDoctor(Long id);
}
