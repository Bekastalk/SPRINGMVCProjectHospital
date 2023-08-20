package peaksoft.service;

import peaksoft.entity.Department;
import peaksoft.exeptions.MyException;

import java.util.List;

public interface DepartmentService {
    void saveDepartment(Department department,Long hospitalId) throws MyException;
    Department getDepartmentById(Long id) throws MyException;
    List<Department> getAllDepartments() throws MyException;
    void updateDepartment(Long id, Department updatedDepartment) throws MyException;
    void deleteDepartment(Long id) throws MyException;

    List<Department> findAll(Long hospitalId);
}

