package peaksoft.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Doctor;
import peaksoft.exeptions.MyException;
import peaksoft.repository.DoctorRepository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@RequiredArgsConstructor
public class DoctorRepositoryImpl implements DoctorRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    public void saveDoctor(Doctor doctor)throws MyException {
        entityManager.persist(doctor);
    }

    public Optional<Doctor> getDoctorById(Long id)throws MyException {
        return Optional.ofNullable(
                entityManager.createQuery("select h from Doctor h where h.id=:id", Doctor.class)
                        .setParameter("id", id )
                        .getSingleResult()
        );
    }

    public List<Doctor> getAllDoctors()throws MyException {
        return entityManager.createQuery("select d from Doctor d", Doctor.class).getResultList();
    }

    public void updateDoctor(Long id, Doctor updatedDoctor) throws MyException{

    }

    public void deleteDoctor(Long id)throws MyException {
        entityManager.remove(entityManager.find(Doctor.class, id));
    }

    @Override
    public List<Doctor> findAll(Long hospitalId) {
        return entityManager.createQuery("select d from Doctor d where d.hospital.id=:hosId", Doctor.class)
                .setParameter("hosId", hospitalId).getResultList();
    }
}
