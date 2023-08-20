package peaksoft.repository;

import peaksoft.entity.Department;
import peaksoft.exeptions.MyException;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository {
    void saveDepartment(Department department) throws MyException;

    Optional<Department> getDepartmentById(Long id) throws MyException;

    List<Department> getAllDepartments() throws MyException;

    void updateDepartment(Long id, Department updatedDepartment) throws MyException;

    void deleteDepartment(Long id) throws MyException;

    List<Department> findAll(Long hospitalId);
}
