package peaksoft.repository;

import peaksoft.entity.Hospital;
import peaksoft.exeptions.MyException;

import java.util.List;
import java.util.Optional;

public interface HospitalRepository {
    void saveHospital(Hospital hospital) ;
    Optional<Hospital> getHospitalById(Long id) ;
    List<Hospital> getAllHospitals() ;
    void updateHospital(Long id, Hospital updatedHospital);
    void deleteHospital(Long id);

}
