package picksovt.repository;

import picksovt.entity.Appointment;

import java.util.List;

public interface AppointmentRepository {
    void saveAppointment(Appointment appointment);
    Appointment getAppointmentById(Long id);
    List<Appointment> getAllAppointments();
    void updateAppointment(Long id, Appointment updatedAppointment);
    void deleteAppointment(Long id);
}
