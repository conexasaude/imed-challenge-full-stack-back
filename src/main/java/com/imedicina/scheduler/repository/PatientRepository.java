package com.imedicina.scheduler.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imedicina.scheduler.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{

    Optional<Patient> findOneByUsernameAndPassword(String username, String password);
}
