package peaksoft.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Hospital;
import peaksoft.repository.HospitalRepository;
import peaksoft.service.HospitalService;

import java.util.List;
@Service
@RequiredArgsConstructor

public class HospitalServiceImpl implements HospitalService {
    private final HospitalRepository repository;


    public void saveHospital(Hospital hospital)  {
        repository.saveHospital(hospital);
    }

    public Hospital getHospitalById(Long id)  {
        return repository.getHospitalById(id).orElseThrow(()-> new RuntimeException("Hospital with id "+id+" not found!"));
    }

    public List<Hospital> getAllHospitals(){
        return repository.getAllHospitals();
    }

    @Transactional
    public void updateHospital(Long id, Hospital updatedHospital) {
        Hospital hospitalById = getHospitalById(id);
        hospitalById.setName(updatedHospital.getName());
        hospitalById.setAddress(updatedHospital.getAddress());
        hospitalById.setImage(updatedHospital.getImage());
    }

    public void deleteHospital(Long id)  {
        repository.deleteHospital(id);
    }

}
