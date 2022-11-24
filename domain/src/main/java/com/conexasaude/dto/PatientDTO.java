package com.conexasaude.dto;

import java.util.HashSet;
import java.util.Set;

public class PatientDTO extends UserDTO {
  private Long totalAppointment;
  private Set<AttendanceDTO> attendances = new HashSet<>();

  public PatientDTO() {}

  public Long getTotalAppointment() {
    return totalAppointment;
  }

  public void setTotalAppointment(Long totalAppointment) {
    this.totalAppointment = totalAppointment;
  }

  public Set<AttendanceDTO> getAttendances() {
    return attendances;
  }

  public void setAttendances(Set<AttendanceDTO> attendances) {
    this.attendances = attendances;
  }
}
