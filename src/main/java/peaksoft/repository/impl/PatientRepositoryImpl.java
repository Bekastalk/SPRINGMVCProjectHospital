package peaksoft.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Patient;
import peaksoft.exeptions.MyException;
import peaksoft.repository.PatientRepository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class PatientRepositoryImpl implements PatientRepository {

    @PersistenceContext
    private  EntityManager entityManager;

    public void savePatient(Patient patient) throws MyException {
        entityManager.persist(patient);
    }

    public Optional<Patient> getPatientById(Long id)throws MyException {
        return Optional.ofNullable(
                entityManager.createQuery("select h from Patient h where h.id=:id", Patient.class)
                        .setParameter("id", id )
                        .getSingleResult()
        );
    }

    public List<Patient> getAllPatients()throws MyException {
        return entityManager.createQuery("select p from Patient p", Patient.class).getResultList();
    }

    public void updatePatient(Long id, Patient updatedPatient)throws MyException {

    }

    public void deletePatient(Long id) {
        entityManager.persist(entityManager.find(Patient.class, id));
    }

    @Override
    public List<Patient> findAll(Long hospitalId) {
        return entityManager.createQuery("select d from Patient d where d.hospital.id=:hosId", Patient.class)
                .setParameter("hosId", hospitalId).getResultList();
    }

}
