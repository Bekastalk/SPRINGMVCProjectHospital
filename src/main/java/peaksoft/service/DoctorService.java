package peaksoft.service;


import peaksoft.entity.Doctor;
import peaksoft.exeptions.MyException;

import java.util.List;

public interface DoctorService {
    void saveDoctor(Doctor doctor,Long departmentId)throws MyException;
    Doctor getDoctorById(Long id)throws MyException;
    List<Doctor> getAllDoctors()throws MyException;
    void updateDoctor(Long id, Doctor updatedDoctor)throws MyException;
    void deleteDoctor(Long id)throws MyException;

    List<Doctor> findAll(Long hospitalId);

    void assign(Long doctorId, Long departmentId);
}
