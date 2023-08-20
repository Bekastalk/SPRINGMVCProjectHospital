package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Patient;
import peaksoft.exeptions.MyException;
import peaksoft.service.PatientService;

@Controller
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientApi {

    private final PatientService patientService;

    @GetMapping()
    String findAll(Model model){
        try {
            model.addAttribute("allPatients", patientService.getAllPatients());
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
        return "Patient/getAllPat";
    }

    @GetMapping("/create/{hospitalId}")
    String createDepartmentByHospitalId(@PathVariable Long hospitalId, Model model){
        model.addAttribute("hospitalId", hospitalId);
        model.addAttribute("newPatient", new Patient());
        return "Patient/save-page";
    }

    @RequestMapping (value = "/save/{hospitalId}", method = RequestMethod.POST)
    String saveDepartment(@PathVariable Long hospitalId, @ModelAttribute Patient patient){
        try {
            patientService.savePatient(patient,hospitalId);
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/patient/" +hospitalId;
    }
    @GetMapping("/{hospitalId}")
    String findAllDepartmentByHospitalId(Model model, @PathVariable Long hospitalId){
        model.addAttribute("hospitalId",hospitalId);
        model.addAttribute("patients", patientService.findAll(hospitalId));
        return "Patient/findDepartmentByHospital";
    }

    @DeleteMapping("{patientId}/patDelete")
    String deleteHospital(@PathVariable("patientId") Long id ){
            patientService.deletePatient(id);
        return "redirect:/patient";
    }

    @GetMapping("{patientId}/patUpdate")
    public String newUpdate(@PathVariable Long patientId, Model model) {
        try {
            model.addAttribute("patUpdate",patientService.getPatientById(patientId));
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
        return "Patient/patUpdate";
    }

    @PostMapping("{patientId}/patEdit")
    public String updateHos(@PathVariable Long patientId, @ModelAttribute("patUpdate") Patient newPatient) {
        try {
            patientService.updatePatient(patientId, newPatient);
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/patient";
    }
}
