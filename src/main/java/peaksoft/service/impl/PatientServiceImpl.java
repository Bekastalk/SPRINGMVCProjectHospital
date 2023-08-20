package peaksoft.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Hospital;
import peaksoft.entity.Patient;
import peaksoft.exeptions.MyException;
import peaksoft.repository.HospitalRepository;
import peaksoft.repository.PatientRepository;
import peaksoft.service.PatientService;

import java.util.List;

@Service
@RequiredArgsConstructor

public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    private final HospitalRepository hospitalRepository;

    @Transactional
    public void savePatient(Patient patient, Long hospitalId) throws MyException {
        Hospital hospital = hospitalRepository.getHospitalById(hospitalId).orElse(null);
        hospital.addPat(patient);
        patient.setHospital(hospital);
        patientRepository.savePatient(patient);
    }

    public Patient getPatientById(Long id) throws MyException {
        return patientRepository.getPatientById(id).orElseThrow(()->new RuntimeException("id not found"));
    }

    public List<Patient> getAllPatients() throws MyException {
        return patientRepository.getAllPatients();
    }

    @Transactional
    public void updatePatient(Long id, Patient updatedPatient) throws MyException {
        Patient patientById = getPatientById(id);
        patientById.setFirstName(updatedPatient.getFirstName());
        patientById.setLastName(updatedPatient.getLastName());
        patientById.setGender(updatedPatient.getGender());
        patientById.setPhoneNumber(updatedPatient.getPhoneNumber());
        patientById.setEmail(updatedPatient.getEmail());
    }

    public void deletePatient(Long id){
        patientRepository.deletePatient(id);
    }

    @Override
    public List<Patient> findAll(Long hospitalId) {
        return patientRepository.findAll(hospitalId);
    }
}
