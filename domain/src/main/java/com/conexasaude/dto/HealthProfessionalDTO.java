package com.conexasaude.dto;

import com.conexasaude.enums.SpecialtyType;

import java.util.HashSet;
import java.util.Set;

public class HealthProfessionalDTO extends UserDTO {
  private String crm;
  private String rating;
  private SpecialtyType specialty;
  private Set<AttendanceDTO> attendances = new HashSet<>();

  public HealthProfessionalDTO() {}

  public String getCrm() {
    return crm;
  }

  public void setCrm(String crm) {
    this.crm = crm;
  }

  public String getRating() {
    return rating;
  }

  public void setRating(String rating) {
    this.rating = rating;
  }

  public SpecialtyType getSpecialty() {
    return specialty;
  }

  public void setSpecialty(SpecialtyType specialty) {
    this.specialty = specialty;
  }

  public Set<AttendanceDTO> getAttendances() {
    return attendances;
  }

  public void setAttendances(Set<AttendanceDTO> attendances) {
    this.attendances = attendances;
  }
}
