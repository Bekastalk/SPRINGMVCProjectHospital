package picksovt.repository;

import picksovt.entity.Department;

import java.util.List;

public interface DepartmentRepository {
    void saveDepartment(Department department);

    Department getDepartmentById(Long id);

    List<Department> getAllDepartments();

    void updateDepartment(Long id, Department updatedDepartment);

    void deleteDepartment(Long id);
}
