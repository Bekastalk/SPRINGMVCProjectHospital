package peaksoft.repository;

import peaksoft.entity.Doctor;
import peaksoft.exeptions.MyException;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository {
    void saveDoctor(Doctor doctor) throws MyException;
    Optional<Doctor> getDoctorById(Long id) throws MyException;
    List<Doctor> getAllDoctors() throws MyException;
    void updateDoctor(Long id, Doctor updatedDoctor) throws MyException;
    void deleteDoctor(Long id) throws MyException;

    List<Doctor> findAll(Long hospitalId);
}
