package com.conexasaude.repository;

import com.conexasaude.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
  PatientEntity findByUsername(String username);
}
