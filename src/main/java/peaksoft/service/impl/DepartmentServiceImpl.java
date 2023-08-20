package peaksoft.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Department;
import peaksoft.entity.Hospital;
import peaksoft.exeptions.MyException;
import peaksoft.repository.DepartmentRepository;
import peaksoft.repository.HospitalRepository;
import peaksoft.service.DepartmentService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repository;
    private final HospitalRepository hospitalRepository;

    @Transactional
    public void saveDepartment(Department department,Long hispitalId) throws MyException {
        Hospital hospital = hospitalRepository.getHospitalById(hispitalId).orElse(null);
        hospital.addDep(department);
        department.setHospital(hospital);
        repository.saveDepartment(department);
    }

    public Department getDepartmentById(Long id) throws MyException {
        return repository.getDepartmentById(id).orElseThrow(()-> new RuntimeException("Department with id "+id+" not found!"));
    }

    public List<Department> getAllDepartments() throws MyException {
        return repository.getAllDepartments();
    }

    @Transactional
    public void updateDepartment(Long id, Department updatedDepartment) throws MyException {
        Department department = getDepartmentById(id);
        department.setName(updatedDepartment.getName());
          }

    public void deleteDepartment(Long id) throws MyException {
        repository.deleteDepartment(id);
    }

    @Override
    public List<Department> findAll(Long hospitalId) {
        return repository.findAll(hospitalId);
    }

}
