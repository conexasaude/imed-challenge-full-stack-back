package com.imedicina.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imedicina.scheduler.model.Professional;

@Repository
public interface ProfessionalRepository extends JpaRepository<Professional, Long>{}
