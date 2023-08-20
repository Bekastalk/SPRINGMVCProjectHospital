package peaksoft.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import peaksoft.entity.Hospital;
import peaksoft.repository.HospitalRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class HospitalRepositoryImpl implements HospitalRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void saveHospital(Hospital hospital){
        entityManager.persist(hospital);
    }
    @Transactional
    public Optional<Hospital> getHospitalById(Long id){
        return Optional.ofNullable(
                entityManager.createQuery("select h from Hospital h where h.id=:id", Hospital.class)
                        .setParameter("id", id )
                        .getSingleResult()
        );
    }

    @Transactional
    public List<Hospital> getAllHospitals(){
        return entityManager.createQuery("select h from Hospital h", Hospital.class).getResultList();
    }


    public void updateHospital(Long id, Hospital updatedHospital) {
//        Hospital hospitalById = entityManager.find(Hospital.class, id);
//        hospitalById.setName(updatedHospital.getName());
//        hospitalById.setAddress(updatedHospital.getAddress());
//        hospitalById.setImage(updatedHospital.getImage());
    }

    @Transactional
    public void deleteHospital(Long id) {
        entityManager.remove(entityManager.find(Hospital.class,id));
    }
}
