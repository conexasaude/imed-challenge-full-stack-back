package com.conexasaude.rest.controller;

import com.conexasaude.dto.PatientDTO;
import com.conexasaude.entity.PatientEntity;
import com.conexasaude.exceptions.ImedApplicationException;
import com.conexasaude.usecases.PatientServiceImpl;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "patient")
public class PatientController {

  private final PatientServiceImpl patientService;

  public PatientController(PatientServiceImpl patientService) {
    this.patientService = patientService;
  }

  @GetMapping("{id}")
  @ResponseStatus(code = HttpStatus.OK)
  public PatientEntity findById(@PathVariable Long id) {
    return patientService
        .findById(id)
        .orElseThrow(() -> new ImedApplicationException("Entity not found"));
  }

  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  public List<PatientEntity> findAll() {
    return patientService.findAll();
  }

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public PatientEntity create(@NonNull @RequestBody PatientDTO request) {
    return patientService.create(request);
  }

  @PutMapping("/{id}")
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  public PatientEntity update(@PathVariable Long id, @NonNull @RequestBody PatientDTO request) {
    return patientService.update(id, request);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("id") Long id) {
    patientService.delete(id);
  }
}
