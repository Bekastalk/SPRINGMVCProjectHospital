package peaksoft.repository;

import peaksoft.entity.Department;
import peaksoft.entity.Patient;
import peaksoft.exeptions.MyException;

import java.util.List;
import java.util.Optional;

public interface PatientRepository {
    void savePatient(Patient patient) throws MyException;
    Optional<Patient> getPatientById(Long id) throws MyException;
    List<Patient> getAllPatients() throws MyException;
    void updatePatient(Long id, Patient updatedPatient) throws MyException;
    void deletePatient(Long id);

    List<Patient> findAll(Long hospitalId);
}
