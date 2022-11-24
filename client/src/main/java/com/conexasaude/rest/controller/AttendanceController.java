package com.conexasaude.rest.controller;

import com.conexasaude.dto.AttendanceDTO;
import com.conexasaude.entity.Attendance;
import com.conexasaude.entity.AttendanceEntity;
import com.conexasaude.exceptions.ImedApplicationException;
import com.conexasaude.usecases.AttendanceServiceImpl;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "attendance")
public class AttendanceController {

  private final AttendanceServiceImpl attendanceService;

  public AttendanceController(AttendanceServiceImpl attendanceService) {
    this.attendanceService = attendanceService;
  }

  @GetMapping("{id}")
  @ResponseStatus(code = HttpStatus.OK)
  public AttendanceEntity findById(@PathVariable Long id) {
    return attendanceService
        .findById(id)
        .orElseThrow(() -> new ImedApplicationException("Entity not found"));
  }

  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  public List<AttendanceEntity> findAll() {
    return attendanceService.findAll();
  }

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public Attendance create(@NonNull @RequestBody AttendanceDTO request) {
    return attendanceService.create(request);
  }

  @PutMapping("/{id}")
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  public AttendanceEntity update(
      @PathVariable Long id, @NonNull @RequestBody AttendanceDTO request) {
    return attendanceService.update(id, request);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("id") Long id) {
    attendanceService.delete(id);
  }
}
