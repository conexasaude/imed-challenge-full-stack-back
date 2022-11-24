package com.conexasaude.repository;

import com.conexasaude.entity.HealthProfessionalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthProfessionalRepository
    extends JpaRepository<HealthProfessionalEntity, Long> {
  HealthProfessionalEntity findByUsername(String username);
}
