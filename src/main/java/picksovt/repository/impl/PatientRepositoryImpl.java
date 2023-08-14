package picksovt.repository.impl;

import picksovt.entity.Patient;
import picksovt.exeptions.MyException;
import picksovt.repository.PatientRepository;

import java.awt.print.Pageable;
import java.util.List;

public class PatientRepositoryImpl implements PatientRepository {

    public void savePatient(Patient patient) throws MyException {

    }

    public Patient getPatientById(Long id)throws MyException {
        return null;
    }

    public List<Patient> getAllPatients()throws MyException {
        return null;
    }

    public void updatePatient(Long id, Patient updatedPatient)throws MyException {

    }

    public void deletePatient(Long id)throws MyException {

    }
}
