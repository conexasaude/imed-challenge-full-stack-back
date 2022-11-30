package com.imedicina.scheduler.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.imedicina.scheduler.model.Appointment;
import com.imedicina.scheduler.model.dto.AppointmentDTO;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

    @Query(value="SELECT apt.id as id, apt.professional_id as professionalId, prof.name as professionalName, prof.status as status, apt.begining as begining, apt.ending as ending FROM appointment apt JOIN professional prof ON prof.id = apt.professional_id WHERE apt.patient_id = ?1 ORDER BY apt.begining", nativeQuery = true)
    List<AppointmentDTO> findByIdPatientOrderByBegining(Long idPatient);

    @Query(value="SELECT * FROM appointment apt WHERE apt.professional_id = ?1 AND apt.begining = ?2", nativeQuery = true)
    Appointment findOneByIdProfessionalAndBegining(Long idProfessional, Date begining);

    @Query(value="SELECT * FROM appointment apt WHERE apt.professional_id = ?1 ORDER BY apt.begining", nativeQuery = true)
    List<Appointment> findByIdProfessionalOrderByBegining(Long id);
}
