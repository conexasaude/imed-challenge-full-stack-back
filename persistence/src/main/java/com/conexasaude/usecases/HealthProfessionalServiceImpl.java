package com.conexasaude.usecases;

import com.conexasaude.dto.HealthProfessionalDTO;
import com.conexasaude.entity.HealthProfessionalEntity;
import com.conexasaude.exceptions.ImedApplicationException;
import com.conexasaude.repository.AddressRepository;
import com.conexasaude.repository.AttendanceRepository;
import com.conexasaude.repository.HealthProfessionalRepository;
import com.conexasaude.repository.PatientRepository;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class HealthProfessionalServiceImpl implements HealthProfessionalService {

  private static final ModelMapper modelMapper = new ModelMapper();

  private final AttendanceRepository attendanceRepository;
  private final PatientRepository patientRepository;
  private final HealthProfessionalRepository professionalRepository;
  private final AddressRepository addressRepository;

  public HealthProfessionalServiceImpl(
      AttendanceRepository attendanceRepository,
      PatientRepository patientRepository,
      HealthProfessionalRepository professionalRepository,
      AddressRepository addressRepository) {
    this.attendanceRepository = attendanceRepository;
    this.patientRepository = patientRepository;
    this.professionalRepository = professionalRepository;
    this.addressRepository = addressRepository;
  }

  public Optional<HealthProfessionalEntity> findById(Long id) {
    return professionalRepository.findById(id);
  }

  public List<HealthProfessionalEntity> findAll() {
    return professionalRepository.findAll();
  }

  @Transactional
  public HealthProfessionalEntity create(@NonNull HealthProfessionalDTO request) {
    HealthProfessionalEntity entity = modelMapper.map(request, HealthProfessionalEntity.class);
    addressRepository.save(entity.getAddress());
    return professionalRepository.save(entity);
  }

  @Transactional
  public HealthProfessionalEntity update(@NonNull Long id, @NonNull HealthProfessionalDTO request) {
    HealthProfessionalEntity entity = modelMapper.map(request, HealthProfessionalEntity.class);
    return professionalRepository
        .findById(id)
        .map(
            e -> {
              e = entity;
              e.setId(id);
              return professionalRepository.save(e);
            })
        .orElseThrow(() -> new ImedApplicationException("Entity not found"));
  }

  @Transactional
  public void delete(Long id) {
    professionalRepository.deleteById(id);
  }
}
