package com.example.hospital_management_system.controller;

import com.example.hospital_management_system.Dto.DoctorDTO;
import com.example.hospital_management_system.service.DoctorService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Doctor")
public class DoctorResource {
    private  final Logger log = LoggerFactory.getLogger(DoctorResource.class);

    private DoctorService doctorService;

    public DoctorResource(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
    @GetMapping
    public ResponseEntity<List<DoctorDTO>> getAllDoctor() {
        return ResponseEntity.ok().body(doctorService.getAllDoctors());
    }
    //    @GetMapping("/{patientId}")
    //    public ResponseEntity<List<DoctorDTO>> getDoctorsByPatient(@PathVariable Long patientId) {
    //        List<DoctorDTO> doctors = doctorService.getDoctorsforPatient(   patientId);
    //
    //        if (doctors.isEmpty()) {
    //            return ResponseEntity.notFound().build();
    //        }
    //
    //        return ResponseEntity.ok(doctors);
    //    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDTO> getDoctorById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(doctorService.getDoctorById(id));
    }

    @PostMapping
    public ResponseEntity<DoctorDTO> createSpecialty(@Valid @RequestBody DoctorDTO doctorDTO) {
        if (doctorDTO.getID() != null) {
            log.error("Cannot have an ID: {}", doctorDTO);
            return (ResponseEntity<DoctorDTO>) ResponseEntity.badRequest();
        }
        return new ResponseEntity<>(doctorService.createDoctor(doctorDTO), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorDTO> updateSpeciality(
            @Valid @RequestBody DoctorDTO doctorDTO,
            @PathVariable(name = "id") long id
    ) {
        return new ResponseEntity<>(doctorService.updateDoctor(id, doctorDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSpecialty(@PathVariable(name = "id") long id) {
        doctorService.deleteDoctor(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }



}
