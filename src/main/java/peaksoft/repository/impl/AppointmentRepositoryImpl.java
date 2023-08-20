package peaksoft.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Repository;
import peaksoft.entity.Appointment;
import peaksoft.exeptions.MyException;
import peaksoft.repository.AppointmentRepository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional

public class AppointmentRepositoryImpl implements AppointmentRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public void saveAppointment(Appointment appointment) throws MyException {
        entityManager.persist(appointment);
    }

    public Optional<Appointment> getAppointmentById(Long id) throws MyException {
        return Optional.ofNullable(
                entityManager.createQuery("select h from Appointment h where h.id=:id", Appointment.class)
                        .setParameter("id", id )
                        .getSingleResult()
        );
    }

    public List<Appointment> getAllAppointments() throws MyException {
        return entityManager.createQuery("select a from Appointment a", Appointment.class).getResultList();
    }

    public void updateAppointment(Long id, Appointment updatedAppointment) throws MyException {

    }

    public void deleteAppointment(Long id) throws MyException {
        entityManager.remove(entityManager.find(Appointment.class, id));
    }


    public List<Appointment> findAll(Long id) {
        return entityManager.createQuery("select h from Hospital l " +
                "join l.appointments h where l.id=:id " +
                "order by h.id desc", Appointment.class)
                .setParameter("id",id).getResultList();
    }
}
