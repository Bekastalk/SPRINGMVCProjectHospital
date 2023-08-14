package picksovt.repository;

import picksovt.entity.Doctor;
import picksovt.exeptions.MyException;

import java.util.List;

public interface DoctorRepository {
    void saveDoctor(Doctor doctor,Long departmentId) throws MyException;
    Doctor getDoctorById(Long id) throws MyException;
    List<Doctor> getAllDoctors() throws MyException;
    void updateDoctor(Long id, Doctor updatedDoctor) throws MyException;
    void deleteDoctor(Long id) throws MyException;
}
