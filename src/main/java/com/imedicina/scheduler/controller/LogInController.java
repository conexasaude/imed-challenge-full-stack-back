package com.imedicina.scheduler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imedicina.scheduler.model.Patient;
import com.imedicina.scheduler.model.dto.PatientDTO;
import com.imedicina.scheduler.service.PatientService;

@Controller
@RequestMapping("/api/login")
public class LogInController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/patient")
    @ResponseBody
    public ResponseEntity<Patient> login(@RequestBody PatientDTO patient) {
        Patient response = patientService
            .findPatient(patient.getUsername(), patient.getPassword());
        return ResponseEntity.ok(response);
    }

    
}
