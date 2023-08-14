package picksovt.service.impl;

import picksovt.entity.Patient;
import picksovt.exeptions.MyException;
import picksovt.repository.PatientRepository;
import picksovt.repository.impl.PatientRepositoryImpl;
import picksovt.service.PatientService;

import java.util.List;

public class PatientServiceImpl implements PatientService {
    PatientRepository patientRepository = new PatientRepositoryImpl();

    public void savePatient(Patient patient) throws MyException {
        patientRepository.savePatient(patient);
    }

    public Patient getPatientById(Long id) throws MyException {
        return patientRepository.getPatientById(id);
    }

    public List<Patient> getAllPatients() throws MyException {
        return patientRepository.getAllPatients();
    }

    public void updatePatient(Long id, Patient updatedPatient) throws MyException {
        patientRepository.updatePatient(id, updatedPatient);
    }

    public void deletePatient(Long id) throws MyException {
        patientRepository.deletePatient(id);
    }
}
