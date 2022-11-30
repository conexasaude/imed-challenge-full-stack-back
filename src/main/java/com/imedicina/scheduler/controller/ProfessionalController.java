package com.imedicina.scheduler.controller;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.access.prepost.PreAuthorize;
// import org.springframework.security.core.annotation.AuthenticationPrincipal;
// // import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// import com.imedicina.scheduler.model.Professional;
import com.imedicina.scheduler.service.ProfessionalService;

@RestController
@RequestMapping("/api/professionals")
public class ProfessionalController {
    @Autowired
    ProfessionalService professionalService;

    // @GetMapping("/{id}")
    // @PreAuthorize("#professional.id == #id")
    // public ResponseEntity<ProfessionalDTO> user(/*@AuthenticationPrincipal Professional professional,*/ @PathVariable Long id) {
    //     return ResponseEntity.ok(ProfessionalDTO.from(professionalService.findById(id).orElseThrow()));
    // }
}