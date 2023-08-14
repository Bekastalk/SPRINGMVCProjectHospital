package picksovt.service.impl;

import picksovt.entity.Department;
import picksovt.repository.DepartmentRepository;
import picksovt.repository.impl.DepartmentRepositoryImpl;
import picksovt.service.DepartmentService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
    DepartmentRepository repository = new DepartmentRepositoryImpl();

    public void saveDepartment(Department department) {
        repository.saveDepartment(department);
    }

    public Department getDepartmentById(Long id) {
        return repository.getDepartmentById(id);
    }

    public List<Department> getAllDepartments() {
        return repository.getAllDepartments();
    }

    public void updateDepartment(Long id, Department updatedDepartment) {
        repository.updateDepartment(id, updatedDepartment);
    }

    public void deleteDepartment(Long id) {
        repository.deleteDepartment(id);
    }

}
