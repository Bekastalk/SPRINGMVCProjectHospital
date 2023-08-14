package picksovt.service;

import picksovt.entity.Department;

import java.util.List;

public interface DepartmentService {
    void saveDepartment(Department department);
    Department getDepartmentById(Long id);
    List<Department> getAllDepartments();
    void updateDepartment(Long id, Department updatedDepartment);
    void deleteDepartment(Long id);
}

