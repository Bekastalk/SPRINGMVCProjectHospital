package picksovt.repository;

import picksovt.entity.Hospital;

import java.util.List;

public interface HospitalRepository {
    void saveHospital(Hospital hospital);
    Hospital getHospitalById(Long id);
    List<Hospital> getAllHospitals();
    void updateHospital(Long id, Hospital updatedHospital);
    void deleteHospital(Long id);
    
}
