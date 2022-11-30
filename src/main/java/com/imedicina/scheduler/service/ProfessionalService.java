package com.imedicina.scheduler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imedicina.scheduler.model.Professional;
import com.imedicina.scheduler.repository.ProfessionalRepository;

@Service
public class ProfessionalService {

    @Autowired
    private ProfessionalRepository professionalRepository;

    public List<Professional> fetchAllProfessionals() {
        return professionalRepository.findAll();
    }

    public Professional save(Professional Professional) {
        return professionalRepository.save(Professional);
    }

    public void remove(Professional Professional) {
        professionalRepository.delete(Professional);
    }

    public Professional findById(Long id) {
        return professionalRepository.findById(id).orElse(new Professional());
    }
}
