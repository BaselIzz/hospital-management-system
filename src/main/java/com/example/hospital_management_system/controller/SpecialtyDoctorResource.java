package com.example.hospital_management_system.controller;

import com.example.hospital_management_system.Dto.SpecialtyDoctorDTO;
import com.example.hospital_management_system.service.SpecialtyDoctorService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/SpecialtyDoctor")
public class SpecialtyDoctorResource {
    private final Logger log = LoggerFactory.getLogger(SpecialtyDoctorResource.class);
    private SpecialtyDoctorService specitlydoctorService;


    public SpecialtyDoctorResource(SpecialtyDoctorService specitlydoctorService) {
        this.specitlydoctorService = specitlydoctorService;
    }

    @GetMapping
    public ResponseEntity<List<SpecialtyDoctorDTO>> getAllDoctorSpecialty() {
        return ResponseEntity.ok().body(specitlydoctorService.getAllSpecialtyDoctors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpecialtyDoctorDTO> getSpecialtyDoctorById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(specitlydoctorService.getSpecialtyDoctorById(id));
    }

    @PostMapping
    public ResponseEntity<SpecialtyDoctorDTO> createSpecialty(@Valid @RequestBody SpecialtyDoctorDTO specialtydoctorDTO) {
        if (specialtydoctorDTO.getId() != null) {
            log.error("Cannot have an ID: {}", specialtydoctorDTO);
            return (ResponseEntity<SpecialtyDoctorDTO>) ResponseEntity.badRequest();
        }
        return new ResponseEntity<>(specitlydoctorService.createSpecialtyDoctor(specialtydoctorDTO), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SpecialtyDoctorDTO> updateSpeciality(
            @Valid @RequestBody SpecialtyDoctorDTO specialtydoctorDTO,
            @PathVariable(name = "id") long id
    ) {
        return new ResponseEntity<>(specitlydoctorService.updateSpecialtyDoctor(id, specialtydoctorDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSpecialty(@PathVariable(name = "id") long id) {
        specitlydoctorService.deleteSpecialtyDoctor(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }
}




