package peaksoft.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Department;
import peaksoft.entity.Doctor;
import peaksoft.entity.Hospital;
import peaksoft.exeptions.MyException;
import peaksoft.repository.DoctorRepository;
import peaksoft.repository.HospitalRepository;
import peaksoft.service.DepartmentService;
import peaksoft.service.DoctorService;

import java.util.Collections;
import java.util.List;
@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository repository;
    private final HospitalRepository hospitalRepository;
    private final DepartmentService departmentService;

    @Transactional
    public void saveDoctor(Doctor doctor,Long hispitalId) throws MyException {
        Hospital hospital = hospitalRepository.getHospitalById(hispitalId).orElse(null);
        hospital.addDoc(doctor);
        doctor.setHospital(hospital);
        repository.saveDoctor(doctor);
    }

    public Doctor getDoctorById(Long id) throws MyException {
        return repository.getDoctorById(id).orElseThrow(()-> new RuntimeException("Department with id "+id+" not found!"));
    }

    public List<Doctor> getAllDoctors() throws MyException {
        return repository.getAllDoctors();
    }

    @Transactional
    public void updateDoctor(Long id, Doctor updatedDoctor) throws MyException {
        Doctor doctorById = getDoctorById(id);
        doctorById.setFirstName(updatedDoctor.getFirstName());
        doctorById.setLastName(updatedDoctor.getLastName());
        doctorById.setGender(updatedDoctor.getGender());
        doctorById.setPosition(updatedDoctor.getPosition());
        doctorById.setEmail(updatedDoctor.getEmail());
    }

    public void deleteDoctor(Long id) throws MyException {
        repository.deleteDoctor(id);
    }

    @Override
    public List<Doctor> findAll(Long hospitalId) {
        return repository.findAll(hospitalId);
    }

    @Override
    @Transactional
    public void assign(Long doctorId, Long departmentId) {
        Doctor doctor = null;
        try {
            doctor = repository.getDoctorById(doctorId)
                    .orElseThrow(() -> new MyException("Doctor not found with id: " + doctorId));
        } catch (MyException e) {
            throw new RuntimeException(e);
        }

        Department department = null;
        try {
            department = departmentService.getDepartmentById(departmentId);
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
        doctor.setDepartments(Collections.singletonList(department));
        department.addDoc(doctor);
    }


}
