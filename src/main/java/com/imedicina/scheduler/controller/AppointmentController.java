package com.imedicina.scheduler.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.imedicina.scheduler.model.Appointment;
import com.imedicina.scheduler.model.Professional;
import com.imedicina.scheduler.model.dto.AppointmentDTO;
import com.imedicina.scheduler.service.AppointmentService;
import com.imedicina.scheduler.service.ProfessionalService;

@RestController
@RequestMapping(path = "/api/appointments")
public class AppointmentController {
    
    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private ProfessionalService professionalService;

    @GetMapping("/patient/{id}")
    @ResponseBody
    public ResponseEntity<List<AppointmentDTO>> fetchAppointmentsForPatient(@PathVariable Long id) {
        List<AppointmentDTO> response = appointmentService.fetchAppointmentsByPatientId(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/professional/{id}")
    @ResponseBody
    public ResponseEntity<List<Appointment>> fetchAppointmentsForProfessional(@PathVariable Long id) {
        List<Appointment> response = appointmentService.fetchAppointmentsByProfessionalId(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/professional")
    @ResponseBody
    public ResponseEntity<List<Professional>> fetchProfessionals() {
        List<Professional> response = professionalService.fetchAllProfessionals();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/professional/verifyTimeBox")
    @ResponseBody
    public ResponseEntity<Boolean> isThisAppointmentFree(@RequestBody AppointmentDTO appointment) {
        Boolean response = appointmentService.isThisAppointmentFree(appointment.getProfessionalId(), appointment.getBegining());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/patient/create-appointment")
    @ResponseBody
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment ap) {
        Appointment registered = appointmentService.save(ap);
        return ResponseEntity.ok(registered);
    }

    @DeleteMapping("/patient/delete-appointment/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        appointmentService.remove(id);
    }
}
