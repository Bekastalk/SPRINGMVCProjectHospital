package picksovt.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import picksovt.entity.Appointment;
import picksovt.exeptions.MyException;
import picksovt.repository.AppointmentRepository;

import java.util.List;

@Repository
@Transactional

public class AppointmentRepositoryImpl implements AppointmentRepository {

    @PersistenceContext
    private EntityManager entityManager = null;

    @Autowired
    public void AgencyRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void saveAppointment(Appointment appointment)throws MyException {
        entityManager.persist(appointment);
    }

    public Appointment getAppointmentById(Long id) throws MyException {
        Appointment appointment = entityManager.find(Appointment.class, id);
        if (appointment == null) throw new MyException("Appointment with id:" + id + "not find");
    return appointment;
    }

    public List<Appointment> getAllAppointments() throws MyException {
        return null;
    }

    public void updateAppointment(Long id, Appointment updatedAppointment) throws MyException {

    }

    public void deleteAppointment(Long id) throws MyException{

    }
}
