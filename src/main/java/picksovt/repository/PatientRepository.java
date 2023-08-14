package picksovt.repository;

import picksovt.entity.Patient;

import java.util.List;

public interface PatientRepository {
    void savePatient(Patient patient);
    Patient getPatientById(Long id);
    List<Patient> getAllPatients();
    void updatePatient(Long id, Patient updatedPatient);
    void deletePatient(Long id);
}
