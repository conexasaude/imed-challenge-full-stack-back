package com.conexasaude.usecases;

import com.conexasaude.dto.AttendanceDTO;
import com.conexasaude.entity.Attendance;
import com.conexasaude.entity.AttendanceEntity;
import com.conexasaude.entity.HealthProfessionalEntity;
import com.conexasaude.exceptions.ImedApplicationException;
import com.conexasaude.repository.AttendanceRepository;
import com.conexasaude.repository.HealthProfessionalRepository;
import com.conexasaude.repository.PatientRepository;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AttendanceServiceImpl implements AttendanceService {

  private static final ModelMapper modelMapper = new ModelMapper();

  private final AttendanceRepository attendanceRepository;
  private final PatientRepository patientRepository;
  private final HealthProfessionalRepository professionalRepository;

  public AttendanceServiceImpl(
      AttendanceRepository attendanceRepository,
      PatientRepository patientRepository,
      HealthProfessionalRepository professionalRepository) {
    this.attendanceRepository = attendanceRepository;
    this.patientRepository = patientRepository;
    this.professionalRepository = professionalRepository;
  }

  public Optional<AttendanceEntity> findById(Long id) {
    return attendanceRepository.findById(id);
  }

  public List<AttendanceEntity> findAll() {
    return attendanceRepository.findAll();
  }

  @Transactional
  public Attendance create(@NonNull AttendanceDTO request) throws ImedApplicationException {
    if (attendancesContainDate(request.getHealthProfessional().getId(), request.getDate()))
      throw new ImedApplicationException("Date not available");
    AttendanceEntity entity = modelMapper.map(request, AttendanceEntity.class);
    return modelMapper.map(attendanceRepository.save(entity), Attendance.class);
  }

  @Transactional
  public AttendanceEntity update(@NonNull Long id, @NonNull AttendanceDTO request) {
    AttendanceEntity entity = modelMapper.map(request, AttendanceEntity.class);
    return attendanceRepository
        .findById(id)
        .map(
            e -> {
              e = entity;
              e.setId(id);
              return attendanceRepository.save(e);
            })
        .orElseThrow(() -> new ImedApplicationException("Entity not found"));
  }

  @Transactional
  public void delete(Long id) {
    attendanceRepository.deleteById(id);
  }

  @Override
  public boolean attendancesContainDate(Long professionalId, LocalDateTime attendanceDate) {
    return getHealthProfessional(professionalId).getAttendances().stream()
        .map(AttendanceEntity::getDate)
        .collect(Collectors.toSet())
        .contains(attendanceDate);
  }

  private HealthProfessionalEntity getHealthProfessional(Long professionalId)
      throws ImedApplicationException {
    return professionalRepository
        .findById(professionalId)
        .orElseThrow(() -> new ImedApplicationException("Entity not found"));
  }
}
