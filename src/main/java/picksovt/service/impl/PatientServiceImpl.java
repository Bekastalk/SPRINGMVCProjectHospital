package picksovt.service.impl;

import picksovt.entity.Patient;
import picksovt.repository.PatientRepository;
import picksovt.repository.impl.PatientRepositoryImpl;
import picksovt.service.PatientService;

import java.util.List;

public class PatientServiceImpl implements PatientService {
    PatientRepository patientRepository = new PatientRepositoryImpl();

    public void savePatient(Patient patient) {
        patientRepository.savePatient(patient);
    }

    public Patient getPatientById(Long id) {
        return patientRepository.getPatientById(id);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.getAllPatients();
    }

    public void updatePatient(Long id, Patient updatedPatient) {
        patientRepository.updatePatient(id, updatedPatient);
    }

    public void deletePatient(Long id) {
        patientRepository.deletePatient(id);
    }
}
