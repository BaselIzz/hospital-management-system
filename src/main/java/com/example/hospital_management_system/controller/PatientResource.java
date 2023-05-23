package com.example.hospital_management_system.controller;

import com.example.hospital_management_system.Dto.PatientDTO;
import com.example.hospital_management_system.service.PatientService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController@RequestMapping("/Patient")
public class PatientResource {
    private final Logger log = LoggerFactory.getLogger(PatientResource.class);
    private PatientService PatientService;


    public PatientResource(PatientService PatientService) {
        this.PatientService = PatientService;
    }

    @GetMapping
    public ResponseEntity<List<PatientDTO>> getAllPatient() {
        return ResponseEntity.ok().body(PatientService.getAllPatients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(PatientService.getPatientById(id));
    }

    @PostMapping
    public ResponseEntity<PatientDTO> createSpecialty(@Valid @RequestBody PatientDTO patientDTO) {
        if (patientDTO.getId() != null) {
            log.error("Cannot have an ID: {}", patientDTO);
            return (ResponseEntity<PatientDTO>) ResponseEntity.badRequest();
        }
        return new ResponseEntity<>(PatientService.createPatient(patientDTO), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDTO> updateSpeciality(
            @Valid @RequestBody PatientDTO patientDTO,
            @PathVariable(name = "id") long id
    ) {
        return new ResponseEntity<>(PatientService.updatePatient(id, patientDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSpecialty(@PathVariable(name = "id") long id) {
        PatientService.deletePatient(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }


}
