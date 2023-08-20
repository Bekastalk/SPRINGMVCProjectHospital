package peaksoft.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Department;
import peaksoft.exeptions.MyException;
import peaksoft.repository.DepartmentRepository;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@RequiredArgsConstructor
public class DepartmentRepositoryImpl implements DepartmentRepository {
    @PersistenceContext
    private EntityManager entityManager ;


    public void saveDepartment(Department department) throws MyException {
        entityManager.persist(department);
    }

    public Optional<Department> getDepartmentById(Long id) throws MyException {
        return Optional.ofNullable(
                entityManager.createQuery("select h from Department h where h.id=:id", Department.class)
                        .setParameter("id", id )
                        .getSingleResult()
        );
    }

    public List<Department> getAllDepartments() throws MyException {

        return entityManager.createQuery("select d from Department d", Department.class).getResultList();

    }

    public void updateDepartment(Long id, Department updatedDepartment) throws MyException {

    }

    public void deleteDepartment(Long id) throws MyException {
        entityManager.remove(entityManager.find(Department.class,id));

    }

    @Override
    public List<Department> findAll(Long hospitalId) {
        return entityManager.createQuery("select d from Department d where d.hospital.id=:hosId", Department.class)
                .setParameter("hosId", hospitalId).getResultList();
    }
}
