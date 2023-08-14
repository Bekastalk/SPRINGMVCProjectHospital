package picksovt.repository;

import picksovt.entity.Patient;
import picksovt.exeptions.MyException;

import java.util.List;

public interface PatientRepository {
    void savePatient(Patient patient) throws MyException;
    Patient getPatientById(Long id) throws MyException;
    List<Patient> getAllPatients() throws MyException;
    void updatePatient(Long id, Patient updatedPatient) throws MyException;
    void deletePatient(Long id) throws MyException;
}
