package com.conexasaude.usecases;

import com.conexasaude.entity.UserEntity;
import com.conexasaude.repository.HealthProfessionalRepository;
import com.conexasaude.repository.PatientRepository;
import com.conexasaude.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

  private final UserRepository userRepository;
  private final PatientRepository patientRepository;
  private final HealthProfessionalRepository professionalRepository;

  public UserServiceImpl(
      UserRepository userRepository,
      PatientRepository patientRepository,
      HealthProfessionalRepository professionalRepository) {
    this.userRepository = userRepository;
    this.patientRepository = patientRepository;
    this.professionalRepository = professionalRepository;
  }

  public UserEntity findByUsername(String username) {
    final String role = userRepository.findByUsername(username);
    if ("USER".equals(role)) return patientRepository.findByUsername(username);

    return professionalRepository.findByUsername(username);
  }
}
