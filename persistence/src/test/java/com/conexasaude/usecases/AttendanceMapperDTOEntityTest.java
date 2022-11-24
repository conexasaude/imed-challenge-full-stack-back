package com.conexasaude.usecases;

import com.conexasaude.dto.AttendanceDTO;
import com.conexasaude.entity.AttendanceEntity;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AttendanceMapperDTOEntityTest {

  private static final ModelMapper modelMapper = new ModelMapper();

  @Test
  public void checkAttendanceDTOMapping() {
    AttendanceDTO attendanceDTO = new AttendanceDTO();
    attendanceDTO.setDescription("Testing attendance description");

    AttendanceEntity entity = modelMapper.map(attendanceDTO, AttendanceEntity.class);
    assertEquals(attendanceDTO.getDescription(), entity.getDescription());

    AttendanceDTO update = new AttendanceDTO();
    update.setDescription("New attendance description");

    modelMapper.map(update, entity);
    assertEquals(update.getDescription(), entity.getDescription());
  }
}
