package com.imedicina.scheduler.model.dto;

import lombok.Data;

@Data
public class PatientDTO {
    private Long id;
    private String username;
    private String password;
    private Integer totalAppointments;
}
