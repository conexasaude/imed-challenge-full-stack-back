package com.conexasaude.entity;

import com.conexasaude.enums.AttendanceStatus;

import java.time.LocalDateTime;

public class Attendance {
  private Long id;
  private String description;
  private LocalDateTime date;
  private LocalDateTime created;
  private LocalDateTime updated;
  private AttendanceStatus attendanceStatus;
  private HealthProfessional healthProfessional;
  private Patient patient;

  public Attendance() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }

  public LocalDateTime getCreated() {
    return created;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  public LocalDateTime getUpdated() {
    return updated;
  }

  public void setUpdated(LocalDateTime updated) {
    this.updated = updated;
  }

  public AttendanceStatus getAttendanceStatus() {
    return attendanceStatus;
  }

  public void setAttendanceStatus(AttendanceStatus attendanceStatus) {
    this.attendanceStatus = attendanceStatus;
  }

  public HealthProfessional getHealthProfessional() {
    return healthProfessional;
  }

  public void setHealthProfessional(HealthProfessional healthProfessional) {
    this.healthProfessional = healthProfessional;
  }

  public Patient getPatient() {
    return patient;
  }

  public void setPatient(Patient patient) {
    this.patient = patient;
  }
}
