package picksovt.repository.impl;

import picksovt.entity.Doctor;
import picksovt.exeptions.MyException;
import picksovt.repository.DoctorRepository;

import java.util.List;

public class DoctorRepositoryImpl implements DoctorRepository {

    public void saveDoctor(Doctor doctor,Long departmentId)throws MyException {

    }

    public Doctor getDoctorById(Long id)throws MyException {
        return null;
    }

    public List<Doctor> getAllDoctors()throws MyException {
        return null;
    }

    public void updateDoctor(Long id, Doctor updatedDoctor) throws MyException{

    }

    public void deleteDoctor(Long id)throws MyException {

    }
}
