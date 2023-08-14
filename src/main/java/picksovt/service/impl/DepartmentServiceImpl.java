package picksovt.service.impl;

import picksovt.entity.Department;
import picksovt.exeptions.MyException;
import picksovt.repository.DepartmentRepository;
import picksovt.repository.impl.DepartmentRepositoryImpl;
import picksovt.service.DepartmentService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
    DepartmentRepository repository = new DepartmentRepositoryImpl();

    public void saveDepartment(Department department,Long hispitalId) throws MyException {
        repository.saveDepartment(department,hispitalId);
    }

    public Department getDepartmentById(Long id) throws MyException {
        return repository.getDepartmentById(id);
    }

    public List<Department> getAllDepartments() throws MyException {
        return repository.getAllDepartments();
    }

    public void updateDepartment(Long id, Department updatedDepartment) throws MyException {
        repository.updateDepartment(id, updatedDepartment);
    }

    public void deleteDepartment(Long id) throws MyException {
        repository.deleteDepartment(id);
    }

}
