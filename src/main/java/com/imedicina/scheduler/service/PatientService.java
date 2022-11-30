package com.imedicina.scheduler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imedicina.scheduler.model.Patient;
import com.imedicina.scheduler.repository.PatientRepository;

@Service
public class PatientService {
    
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> fetchAllPatients() {
        return patientRepository.findAll();
    }

    public Patient findPatient(String username, String password) {
        return patientRepository.findOneByUsernameAndPassword(username, password).orElse(new Patient());
    }

    public Patient save(Patient Patient) {
        return patientRepository.save(Patient);
    }

    public void remove(Patient Patient) {
        patientRepository.delete(Patient);
    }
}
