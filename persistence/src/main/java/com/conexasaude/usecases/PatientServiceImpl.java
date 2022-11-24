package com.conexasaude.usecases;

import com.conexasaude.dto.PatientDTO;
import com.conexasaude.entity.PatientEntity;
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
public class PatientServiceImpl implements PatientService {

  private static final ModelMapper modelMapper = new ModelMapper();

  private final AttendanceRepository attendanceRepository;
  private final PatientRepository patientRepository;
  private final HealthProfessionalRepository professionalRepository;
  private final AddressRepository addressRepository;

  public PatientServiceImpl(
      AttendanceRepository attendanceRepository,
      PatientRepository patientRepository,
      HealthProfessionalRepository professionalRepository,
      AddressRepository addressRepository) {
    this.attendanceRepository = attendanceRepository;
    this.patientRepository = patientRepository;
    this.professionalRepository = professionalRepository;
    this.addressRepository = addressRepository;
  }

  public List<PatientEntity> findAll() {
    return patientRepository.findAll();
  }

  public Optional<PatientEntity> findById(Long id) {
    return patientRepository.findById(id);
  }

  @Transactional
  public PatientEntity create(@NonNull PatientDTO request) {
    PatientEntity entity = modelMapper.map(request, PatientEntity.class);
    addressRepository.save(entity.getAddress());
    return patientRepository.save(entity);
  }

  @Transactional
  public PatientEntity update(@NonNull Long id, @NonNull PatientDTO request) {
    PatientEntity entity = modelMapper.map(request, PatientEntity.class);
    return patientRepository
        .findById(id)
        .map(
            e -> {
              e = entity;
              e.setId(id);
              return patientRepository.save(e);
            })
        .orElseThrow(() -> new ImedApplicationException("Entity not found"));
  }

  @Transactional
  public void delete(Long id) {
    patientRepository.deleteById(id);
  }
}
