package com.conexasaude.entity;

import com.conexasaude.enums.SpecialtyType;

import java.util.HashSet;
import java.util.Set;

public class HealthProfessional extends User {
  private String crm;
  private String rating;
  private SpecialtyType specialty;
  private Set<Attendance> attendances = new HashSet<>();

  public HealthProfessional() {}

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

  public Set<Attendance> getAttendances() {
    return attendances;
  }

  public void setAttendances(Set<Attendance> attendances) {
    this.attendances = attendances;
  }
}
