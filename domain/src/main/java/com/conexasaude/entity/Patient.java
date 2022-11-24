package com.conexasaude.entity;

import java.util.HashSet;
import java.util.Set;

public class Patient extends User {
  private Long totalAppointment;
  private Set<Attendance> attendances = new HashSet<>();

  public Patient() {}

  public Long getTotalAppointment() {
    return totalAppointment;
  }

  public void setTotalAppointment(Long totalAppointment) {
    this.totalAppointment = totalAppointment;
  }

  public Set<Attendance> getAttendances() {
    return attendances;
  }

  public void setAttendances(Set<Attendance> attendances) {
    this.attendances = attendances;
  }
}
