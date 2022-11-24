package com.conexasaude.rest.controller;

import com.conexasaude.dto.HealthProfessionalDTO;
import com.conexasaude.entity.HealthProfessionalEntity;
import com.conexasaude.exceptions.ImedApplicationException;
import com.conexasaude.usecases.HealthProfessionalServiceImpl;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "health-professional")
public class HealthProfessionalController {

  private final HealthProfessionalServiceImpl healthProfessionalService;

  public HealthProfessionalController(HealthProfessionalServiceImpl healthProfessionalService) {
    this.healthProfessionalService = healthProfessionalService;
  }

  @GetMapping("{id}")
  @ResponseStatus(code = HttpStatus.OK)
  public HealthProfessionalEntity findById(@PathVariable Long id) {
    return healthProfessionalService
        .findById(id)
        .orElseThrow(() -> new ImedApplicationException("Entity not found"));
  }

  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  public List<HealthProfessionalEntity> findAll() {
    return healthProfessionalService.findAll();
  }

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public HealthProfessionalEntity create(@NonNull @RequestBody HealthProfessionalDTO request) {
    return healthProfessionalService.create(request);
  }

  @PutMapping("/{id}")
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  public HealthProfessionalEntity update(
      @PathVariable Long id, @NonNull @RequestBody HealthProfessionalDTO request) {
    return healthProfessionalService.update(id, request);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("id") Long id) {
    healthProfessionalService.delete(id);
  }
}
