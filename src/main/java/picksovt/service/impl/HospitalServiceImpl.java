package picksovt.service.impl;

import picksovt.entity.Hospital;
import picksovt.exeptions.MyException;
import picksovt.repository.HospitalRepository;
import picksovt.repository.impl.HospitalRepositoryImpl;
import picksovt.service.HospitalService;

import java.util.List;

public class HospitalServiceImpl implements HospitalService {
    HospitalRepository repository = new HospitalRepositoryImpl();

    public void saveHospital(Hospital hospital) throws MyException {
        repository.saveHospital(hospital);
    }

    public Hospital getHospitalById(Long id) throws MyException {
        return repository.getHospitalById(id);
    }

    public List<Hospital> getAllHospitals() throws MyException {
        return repository.getAllHospitals();
    }

    public void updateHospital(Long id, Hospital updatedHospital) throws MyException {
        repository.updateHospital(id, updatedHospital);
    }

    public void deleteHospital(Long id) throws MyException {
        repository.deleteHospital(id);
    }

}
