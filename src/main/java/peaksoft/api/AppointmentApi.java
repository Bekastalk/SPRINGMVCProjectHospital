package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Appointment;
import peaksoft.exeptions.MyException;
import peaksoft.service.AppointmentService;
import peaksoft.service.DepartmentService;
import peaksoft.service.DoctorService;
import peaksoft.service.PatientService;

@Controller
@RequestMapping("/appointment")
@RequiredArgsConstructor

public class AppointmentApi {
    private final AppointmentService appointmentService;
    private final PatientService patientService;
    private final DoctorService doctorService;
    private final DepartmentService departmentService;

    @GetMapping()
    String getAllApp(Model model) {
        try {
            model.addAttribute("allAppointments", appointmentService.getAllAppointments());
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
        return "Appointment/getAllApp";
    }

    @GetMapping("/create/{hospitalId}")
    String createAppointmentByHospitalId(@PathVariable Long hospitalId, Model model) {
        model.addAttribute("newAppointment", new Appointment());
        model.addAttribute("allDepartments",departmentService.findAll(hospitalId));
        model.addAttribute("allPatients",patientService.findAll(hospitalId));
        model.addAttribute("allDoctors",doctorService.findAll(hospitalId));
        model.addAttribute(hospitalId);
        return "Appointment/save-page";
    }

    @RequestMapping(value = "/save/{hospitalId}", method = RequestMethod.POST)
    String saveAppointment(@PathVariable Long hospitalId, @ModelAttribute("newAppointment") Appointment appointment) {
        try {
            appointmentService.saveAppointment(appointment, hospitalId);
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/appointment/" + hospitalId;
    }

    @GetMapping("/{hospitalId}")
    String findAllDepartmentByHospitalId(Model model, @PathVariable Long hospitalId) {
        model.addAttribute("hospitalId", hospitalId);
        model.addAttribute("appointments", appointmentService.findAll(hospitalId));
        return "Appointment/findDepartmentByHospital";
    }

    @DeleteMapping("/{hospitalId}/{appointmentId}/delete")
    public String deleteById(@PathVariable Long hospitalId,@PathVariable Long appointmentId) {
        try {
            appointmentService.deleteAppointment(hospitalId,appointmentId);
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/appointments/"+hospitalId;
    }

    @GetMapping("{hospitalId}/{appointmentId}/edit")
    public String newUpdate(@PathVariable Long appointmentId,@PathVariable Long hospitalId, Model model) {
        try {
            model.addAttribute("appUpdate",appointmentService.getAppointmentById(appointmentId));
            model.addAttribute("departments",departmentService.findAll(hospitalId));
            model.addAttribute("doctors",doctorService.findAll(hospitalId));
            model.addAttribute("patients",patientService.findAll(hospitalId));
            model.addAttribute("hospitalId", hospitalId);
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
        return "Appointment/appUpdate";
    }

    @PutMapping("/{hospitalId}/{appointmentId}/update")
    public String update(@PathVariable Long hospitalId, @PathVariable Long appointmentId, @ModelAttribute("appointment") Appointment appointment) {
        try {
            appointmentService.updateAppointment(appointmentId, appointment);
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/appointments/" + hospitalId;
    }
}
