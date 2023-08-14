package picksovt.service.impl;

import picksovt.entity.Appointment;
import picksovt.exeptions.MyException;
import picksovt.repository.AppointmentRepository;
import picksovt.repository.impl.AppointmentRepositoryImpl;
import picksovt.service.AppointmentService;

import java.util.List;

public class AppointmentServiceImpl implements AppointmentService {
    AppointmentRepository repository = new AppointmentRepositoryImpl();

    public void saveAppointment(Appointment appointment) throws MyException {
        repository.saveAppointment(appointment);
    }

    public Appointment getAppointmentById(Long id) throws MyException {
        return repository.getAppointmentById(id);
    }

    public List<Appointment> getAllAppointments() throws MyException {
        return repository.getAllAppointments();
    }

    public void updateAppointment(Long id, Appointment updatedAppointment) throws MyException {
        repository.updateAppointment(id, updatedAppointment);
    }

    public void deleteAppointment(Long id) throws MyException {
        repository.deleteAppointment(id);
    }

}
