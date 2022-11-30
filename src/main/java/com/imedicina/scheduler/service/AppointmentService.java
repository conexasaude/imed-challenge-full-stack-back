package com.imedicina.scheduler.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imedicina.scheduler.model.Appointment;
import com.imedicina.scheduler.model.Professional;
import com.imedicina.scheduler.model.dto.AppointmentDTO;
import com.imedicina.scheduler.repository.AppointmentRepository;

@Service
public class AppointmentService {
    
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private ProfessionalService professionalService;

    public List<Appointment> fetchAllAppointments(){
        return appointmentRepository.findAll();
    }

    
    public List<AppointmentDTO> fetchAppointmentsByPatientId(Long id) {
        return appointmentRepository.findByIdPatientOrderByBegining(id);
    }

    public List<Appointment> fetchAppointmentsByProfessionalId(Long id) {
        return appointmentRepository.findByIdProfessionalOrderByBegining(id);
    }

    public Appointment save(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public void remove(Long id) {
        Appointment ap = appointmentRepository.findById(id).orElse(new Appointment());
        if (ap.getId() != null) {
            appointmentRepository.delete(ap);
        }
    }

    public boolean isThisAppointmentFree(Long professionalId, Date beginingDate) {
        Professional prof = professionalService.findById(professionalId);
        if(prof.getId() != null) {
            Appointment apt = appointmentRepository
                .findOneByIdProfessionalAndBegining(prof.getId(), beginingDate);
                if(apt != null) {
                    return false;
                }
            return true;
        }

        return true;
    }
}
