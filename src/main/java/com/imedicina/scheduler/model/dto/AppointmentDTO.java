package com.imedicina.scheduler.model.dto;

import java.util.Date;

public interface AppointmentDTO {
    Long getId();
    Long getProfessionalId();
    String getProfessionalName();
    String getStatus();
    Date getBegining();
    Date getEnding();
}
