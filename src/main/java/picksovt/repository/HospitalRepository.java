package picksovt.repository;

import picksovt.entity.Hospital;
import picksovt.exeptions.MyException;

import java.util.List;

public interface HospitalRepository {
    void saveHospital(Hospital hospital) throws MyException;
    Hospital getHospitalById(Long id) throws MyException;
    List<Hospital> getAllHospitals() throws MyException;
    void updateHospital(Long id, Hospital updatedHospital) throws MyException;
    void deleteHospital(Long id)throws MyException;

}
