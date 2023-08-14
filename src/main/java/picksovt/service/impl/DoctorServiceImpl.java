package picksovt.service.impl;

import picksovt.entity.Doctor;
import picksovt.repository.DoctorRepository;
import picksovt.repository.impl.DoctorRepositoryImpl;
import picksovt.service.DoctorService;

import java.util.List;

public class DoctorServiceImpl implements DoctorService {
    DoctorRepository repository = new DoctorRepositoryImpl();

    public void saveDoctor(Doctor doctor) {
        repository.saveDoctor(doctor);
    }

    public Doctor getDoctorById(Long id) {
        return repository.getDoctorById(id);
    }

    public List<Doctor> getAllDoctors() {
        return repository.getAllDoctors();
    }

    public void updateDoctor(Long id, Doctor updatedDoctor) {
        repository.updateDoctor(id, updatedDoctor);
    }

    public void deleteDoctor(Long id) {
        repository.deleteDoctor(id);
    }

}
