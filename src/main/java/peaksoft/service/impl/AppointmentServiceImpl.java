package peaksoft.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Appointment;
import peaksoft.entity.Hospital;
import peaksoft.exeptions.MyException;
import peaksoft.repository.*;
import peaksoft.service.AppointmentService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository repository;
    private final HospitalRepository hospitalRepository;
    private final DoctorRepository doctorRepository;
    private final DepartmentRepository departmentRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public void saveAppointment(Appointment appointment, Long hospitalId) throws MyException {
        Hospital hospital = hospitalRepository.getHospitalById(hospitalId).orElse(null);
        Appointment appointment1 = new Appointment();
        appointment1.setId(appointment.getId());
        appointment1.setPatient(patientRepository.getPatientById(appointment.getPatientId()).orElse(null));
        appointment1.setDoctor(doctorRepository.getDoctorById(appointment.getDoctorId()).orElse(null));
        appointment1.setDepartment(departmentRepository.getDepartmentById(appointment.getDepartmentId()).orElse(null));
        appointment1.setDate(appointment.getDate());

        hospital.addApp(appointment1);

        repository.saveAppointment(appointment1);
    }

    public Appointment getAppointmentById(Long id) throws MyException {
        return repository.getAppointmentById(id).orElseThrow(()->new RuntimeException("Id not found!!"));
    }

    public List<Appointment> getAllAppointments() throws MyException {
        return repository.getAllAppointments();
    }

    @Transactional
    public void updateAppointment(Long id, Appointment updatedAppointment) throws MyException {
        Appointment appointment = getAppointmentById(id);
        appointment.setDate(updatedAppointment.getDate());
        appointment.setDoctor(updatedAppointment.getDoctor());
        appointment.setDepartment(appointment.getDepartment());
        appointment.setPatient(updatedAppointment.getPatient());
    }

    public void deleteAppointment(Long id, Long appointmentId) throws MyException {
        repository.deleteAppointment(id);
    }

    @Override
    public List<Appointment> findAll(Long hospitalId) {
        return repository.findAll(hospitalId);
    }

}
