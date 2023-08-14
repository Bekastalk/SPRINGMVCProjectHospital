package picksovt.service.impl;

import picksovt.entity.Appointment;
import picksovt.repository.AppointmentRepository;
import picksovt.repository.impl.AppointmentRepositoryImpl;
import picksovt.service.AppointmentService;

import java.util.List;

public class AppointmentServiceImpl implements AppointmentService {
    AppointmentRepository repository = new AppointmentRepositoryImpl();

    public void saveAppointment(Appointment appointment) {
        repository.saveAppointment(appointment);
    }

    public Appointment getAppointmentById(Long id) {
        return repository.getAppointmentById(id);
    }

    public List<Appointment> getAllAppointments() {
        return repository.getAllAppointments();
    }

    public void updateAppointment(Long id, Appointment updatedAppointment) {
        repository.updateAppointment(id, updatedAppointment);
    }

    public void deleteAppointment(Long id) {
        repository.deleteAppointment(id);
    }

}
