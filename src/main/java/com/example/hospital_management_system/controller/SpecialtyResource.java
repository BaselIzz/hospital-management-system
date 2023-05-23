package com.example.hospital_management_system.controller;

import com.example.hospital_management_system.Dto.SpecialtyDTO;
import com.example.hospital_management_system.service.SpecialtyService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/specialty")
public class SpecialtyResource {
    private final Logger log = LoggerFactory.getLogger(SpecialtyResource.class);
    private SpecialtyService specialtyService;

    public SpecialtyResource(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @GetMapping
    public ResponseEntity<List<SpecialtyDTO>> getAllSpecialty() {
        return ResponseEntity.ok().body(specialtyService.getAllSpecialties());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpecialtyDTO> getSpecialtyById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(specialtyService.getSpecialtyById(id));
    }

    @PostMapping
    public ResponseEntity<SpecialtyDTO> createSpecialty(@Valid @RequestBody SpecialtyDTO specialtyDTO) {
        if (specialtyDTO.getId() != null) {
            log.error("Cannot have an ID: {}", specialtyDTO);
            return (ResponseEntity<SpecialtyDTO>) ResponseEntity.badRequest();
        }
        return new ResponseEntity<>(specialtyService.createSpecialty(specialtyDTO), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SpecialtyDTO> updateSpeciality(
            @Valid @RequestBody SpecialtyDTO specialtyDTO,
            @PathVariable(name = "id") long id
    ) {
        return new ResponseEntity<>(specialtyService.updateSpecialty(id, specialtyDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSpecialty(@PathVariable(name = "id") long id) {
        specialtyService.deleteSpecialty(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }
}
