package com.conexasaude.usecases;

import com.conexasaude.dto.AttendanceDTO;
import com.conexasaude.entity.Attendance;

import java.time.LocalDateTime;

public interface AttendanceService {
  Attendance create(AttendanceDTO request);

  boolean attendancesContainDate(Long idHealthProfessional, LocalDateTime attendanceDate);
}
