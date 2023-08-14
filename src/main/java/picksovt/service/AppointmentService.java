package picksovt.service;

import picksovt.entity.Appointment;

import java.util.List;

public interface AppointmentService {
    void saveAppointment(Appointment appointment);
    Appointment getAppointmentById(Long id);
    List<Appointment> getAllAppointments();
    void updateAppointment(Long id, Appointment updatedAppointment);
    void deleteAppointment(Long id);
}
