package com.example.hospital_management_system.controller;

import com.example.hospital_management_system.Dto.AppointmentDTO;
import com.example.hospital_management_system.service.AppointmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Appointment")

public class AppointmentResource {
    private  final Logger log = LoggerFactory.getLogger(DoctorResource.class);

    private AppointmentService appointmentService;

    public AppointmentResource(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }
    @GetMapping
    public ResponseEntity<List<AppointmentDTO>> getAllDoctor() {
        return ResponseEntity.ok().body(appointmentService.getAllAppointments());
    }


    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDTO> getDoctorById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(appointmentService.getAppointmentById(id));
    }

    @PostMapping
    public ResponseEntity<AppointmentDTO> createSpecialty(@Valid @RequestBody AppointmentDTO appointmentDTO) {
        if (appointmentDTO.getId()!= null) {
            log.error("Cannot have an ID: {}", appointmentDTO);
            return (ResponseEntity<AppointmentDTO>) ResponseEntity.badRequest();
        }
        return new ResponseEntity<>(appointmentService.createAppointment(appointmentDTO), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppointmentDTO> updateSpeciality(
            @Valid @RequestBody AppointmentDTO  appointmentDTO,
            @PathVariable(name = "id") long id
    ) {
        return new ResponseEntity<>(appointmentService.updateAppointment(id, appointmentDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSpecialty(@PathVariable(name = "id") long id) {
        appointmentService.deleteAppointment(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }



}
