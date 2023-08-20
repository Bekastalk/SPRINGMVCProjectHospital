package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Doctor;
import peaksoft.exeptions.MyException;
import peaksoft.service.DepartmentService;
import peaksoft.service.DoctorService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/doctor")
public class DoctorApi {

    private final DoctorService doctorService;
    private final DepartmentService departmentService;


    @GetMapping
    String getAllDoctors(Model model) {
        try {
            model.addAttribute("alldoctors", doctorService.getAllDoctors());
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
        return "Doctor/getAllDoc";
    }
    @GetMapping("/create/{hospitalId}")
    String createDepartmentByHospitalId(@PathVariable Long hospitalId, Model model){
        model.addAttribute("hospitalId", hospitalId);
        model.addAttribute("newDoctor", new Doctor());
        return "Doctor/save-page";
    }

    @GetMapping("/assign/{doctorId}")
    String assingPage(@PathVariable Long doctorId, Model model){
        try {
            model.addAttribute("departments", departmentService.getAllDepartments());
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
        model.addAttribute("doctorId", doctorId);
        return "Doctor/assignPage";
    }


    @PostMapping("/accept/{doctorId}")
    String assign(@PathVariable Long doctorId, Long departmentId){
        doctorService.assign(doctorId, departmentId);
        return "redirect:/doctor/"+departmentId;
    }

    @RequestMapping (value = "/save/{hospitalId}", method = RequestMethod.POST)
    String saveDepartment(@PathVariable Long hospitalId, @ModelAttribute Doctor doctor){
        try {
            doctorService.saveDoctor(doctor, hospitalId);
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/doctor/"+hospitalId;
    }
    @GetMapping("/{hospitalId}")
    String findAllDepartmentByHospitalId(Model model, @PathVariable Long hospitalId){
        model.addAttribute("hospitalId",hospitalId);
        model.addAttribute("doctors", doctorService.findAll(hospitalId));
        return "Doctor/findDoctorByHospital";
    }

    @DeleteMapping("{doctorId}/docDelete")
    String deleteHospital(@PathVariable("doctorId") Long id ){
        try {
            doctorService.deleteDoctor(id);
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/doctor";
    }
    @GetMapping("{doctorId}/docUpdate")
    public String newUpdate(@PathVariable Long doctorId, Model model) {
        try {
            model.addAttribute("docUpdate",doctorService.getDoctorById(doctorId));
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
        return "Doctor/docUpdate";
    }

    @PostMapping("{doctorId}/docEdit")
    public String updateHos(@PathVariable Long doctorId, @ModelAttribute("docUpdate") Doctor newdoctor) {
        try {
            doctorService.updateDoctor(doctorId, newdoctor);
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/doctor";
    }
}
