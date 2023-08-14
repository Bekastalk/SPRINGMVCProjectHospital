package picksovt.service.impl;

import picksovt.entity.Doctor;
import picksovt.exeptions.MyException;
import picksovt.repository.DoctorRepository;
import picksovt.repository.impl.DoctorRepositoryImpl;
import picksovt.service.DoctorService;

import java.util.List;

public class DoctorServiceImpl implements DoctorService {
    DoctorRepository repository = new DoctorRepositoryImpl();

    public void saveDoctor(Doctor doctor,Long departmentId) throws MyException {
        repository.saveDoctor(doctor,departmentId);
    }

    public Doctor getDoctorById(Long id) throws MyException {
        return repository.getDoctorById(id);
    }

    public List<Doctor> getAllDoctors() throws MyException {
        return repository.getAllDoctors();
    }

    public void updateDoctor(Long id, Doctor updatedDoctor) throws MyException {
        repository.updateDoctor(id, updatedDoctor);
    }

    public void deleteDoctor(Long id) throws MyException {
        repository.deleteDoctor(id);
    }

}
