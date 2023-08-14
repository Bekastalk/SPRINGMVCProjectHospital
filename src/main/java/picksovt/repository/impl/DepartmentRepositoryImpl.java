package picksovt.repository.impl;

import picksovt.entity.Department;
import picksovt.entity.Hospital;
import picksovt.exeptions.MyException;
import picksovt.repository.DepartmentRepository;

import java.util.List;

public class DepartmentRepositoryImpl implements DepartmentRepository {

    public void saveDepartment(Department department, Long hospitalId)throws MyException {

    }

    public Department getDepartmentById(Long id)throws MyException {
        return null;
    }

    public List<Department> getAllDepartments()throws MyException {
        return null;
    }

    public void updateDepartment(Long id, Department updatedDepartment)throws MyException {

    }

    public void deleteDepartment(Long id)throws MyException {

    }
}
