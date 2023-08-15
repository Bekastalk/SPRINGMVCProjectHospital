package picksovt.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import picksovt.entity.Department;
import picksovt.entity.Hospital;
import picksovt.exeptions.MyException;
import picksovt.repository.DepartmentRepository;

import java.util.List;

@Repository
@Transactional

public class DepartmentRepositoryImpl implements DepartmentRepository {
    @PersistenceContext
    private EntityManager entityManager = null;

    @Autowired
    public void AgencyRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public void saveDepartment(Department department, Long hospitalId) throws MyException {
        Hospital hospital = entityManager.find(Hospital.class, hospitalId);
        if (hospital == null) throw new MyException("Hospital with id: " + hospitalId + " not found");
        hospital.setDepartments((List<Department>) department);
        entityManager.merge(department);
        entityManager.persist(department);
    }

    public Department getDepartmentById(Long id) throws MyException {
        Department department = entityManager.find(Department.class, id);
        if (department == null) throw new MyException("Hospital with id:" + id + "not find ");
        return department;
    }

    public List<Department> getAllDepartments() throws MyException {

        return null;

    }

    public void updateDepartment(Long id, Department updatedDepartment) throws MyException {
        getDepartmentById(id);


    }

    public void deleteDepartment(Long id) throws MyException {

    }
}
