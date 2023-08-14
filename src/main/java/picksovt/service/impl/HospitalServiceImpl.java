package picksovt.service.impl;

import picksovt.entity.Hospital;
import picksovt.repository.HospitalRepository;
import picksovt.repository.impl.HospitalRepositoryImpl;
import picksovt.service.HospitalService;

import java.util.List;

public class HospitalServiceImpl implements HospitalService {
    HospitalRepository repository = new HospitalRepositoryImpl();

    public void saveHospital(Hospital hospital) {
        repository.saveHospital(hospital);
    }

    public Hospital getHospitalById(Long id) {
        return repository.getHospitalById(id);
    }

    public List<Hospital> getAllHospitals() {
        return repository.getAllHospitals();
    }

    public void updateHospital(Long id, Hospital updatedHospital) {
        repository.updateHospital(id, updatedHospital);
    }

    public void deleteHospital(Long id) {
        repository.deleteHospital(id);
    }

}
