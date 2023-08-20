package peaksoft.service;

import peaksoft.entity.Hospital;
import peaksoft.exeptions.MyException;

import java.util.List;

public interface HospitalService {
    void saveHospital(Hospital hospital);
    Hospital getHospitalById(Long id);
    List<Hospital> getAllHospitals();
    void updateHospital(Long id, Hospital updatedHospital);
    void deleteHospital(Long id) ;
}
