package com.example.hospital_management_system.service.impl;

import com.example.hospital_management_system.Dto.AppointmentDTO;
import com.example.hospital_management_system.Dto.DoctorDTO;
import com.example.hospital_management_system.Dto.PatientDTO;
import com.example.hospital_management_system.entity.Apointment;
import com.example.hospital_management_system.entity.Doctor;
import com.example.hospital_management_system.entity.Patient;
import com.example.hospital_management_system.repository.AppointmentRepository;
import com.example.hospital_management_system.service.AppointmentService;
import com.example.hospital_management_system.service.DoctorService;
import com.example.hospital_management_system.service.PatientService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class AppointmentServiceImplementation implements AppointmentService {

    final AppointmentRepository appointmentRepository;
    final DoctorService doctorService;
    final PatientService patientService;

    public AppointmentServiceImplementation(AppointmentRepository appointmentRepository, DoctorService doctorService, PatientService patientService) {

        this.appointmentRepository = appointmentRepository;
        this.doctorService = doctorService;
        this.patientService = patientService;
    }


    @Override
    public List<AppointmentDTO> getAllAppointments() {
        List<Apointment> appointments = appointmentRepository.findAll();
        return appointments.stream().map(this::mapToDTO).collect(Collectors.toList());

    }

    @Override
    public AppointmentDTO getAppointmentById(Long appointmentId) {
        Apointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(() -> new ResourceAccessException("Appointment"));
        return mapToDTO(appointment);
    }

    @Override
    public AppointmentDTO createAppointment(AppointmentDTO appointmentDTO) {
        Apointment apointment = maptoEntity(appointmentDTO);
        Apointment newapointment = appointmentRepository.save(apointment);
        return mapToDTO(newapointment);


    }

    @Override
    public AppointmentDTO updateAppointment(Long appointmentId, AppointmentDTO appointmentDTO) {
        Apointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(() -> new ResourceAccessException("Appointment"));
        appointment.setPatient(mapToEntityPati(patientService.getPatientById(appointmentDTO.getPatient())));
        //     appointment.setId(appointmentDTO.getId());
        appointment.setRoom(appointmentDTO.getRoom());
        appointment.setCost(appointmentDTO.getCost());
        appointment.setDoctor(mapToEntityDoc(doctorService.getDoctorById(appointmentDTO.getDoctor())));
        appointment.setApointmentDate(appointmentDTO.getAppointmentDate());
        Apointment updatedApointment = appointmentRepository.save(appointment);
        return mapToDTO(updatedApointment);

    }

    @Override
    public void deleteAppointment(Long appointmentId) {
        Apointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(() -> new ResourceAccessException("Appointment"));
        appointmentRepository.delete(appointment);
    }

    private AppointmentDTO mapToDTO(Apointment apointment) {
        AppointmentDTO appointmentDTO = new AppointmentDTO();
        appointmentDTO.setId(apointment.getId());
        appointmentDTO.setAppointmentDate(apointment.getApointmentDate());
        appointmentDTO.setDoctor(apointment.getDoctor().getID());
        appointmentDTO.setPatient(apointment.getPatient().getID());
        appointmentDTO.setCost(apointment.getCost());
        appointmentDTO.setRoom(apointment.getRoom());

        return appointmentDTO;

    }

    private Apointment maptoEntity(AppointmentDTO appointmentDTO) {
        Apointment apointment = new Apointment();
        apointment.setId(appointmentDTO.getId());
        apointment.setRoom(appointmentDTO.getRoom());
        apointment.setCost(appointmentDTO.getCost());
        apointment.setApointmentDate(appointmentDTO.getAppointmentDate());
        apointment.setDoctor(mapToEntityDoc(doctorService.getDoctorById(appointmentDTO.getDoctor())));
        apointment.setPatient(mapToEntityPati(patientService.getPatientById(appointmentDTO.getPatient())));
        return apointment;
    }

    public DoctorDTO mapToDTODoc(Doctor doctor) {
        DoctorDTO doctorDTO = new DoctorDTO();
        doctorDTO.setID(doctor.getID());
        doctorDTO.setName(doctor.getName());
        doctorDTO.setContentNumber(doctor.getContentNumber());

        return doctorDTO;
    }

    // Map to entity
    public Doctor mapToEntityDoc(DoctorDTO doctorDTO) {
        Doctor doctor = new Doctor();
        doctor.setID(doctorDTO.getID());
        doctor.setName(doctorDTO.getName());
        doctor.setContentNumber(doctorDTO.getContentNumber());
        return doctor;
    }

    public Patient mapToEntityPati(PatientDTO patientDTO) {
        Patient patient = new Patient();
        patient.setID(patientDTO.getId());
        patient.setName(patientDTO.getName());
        patient.setSex(patientDTO.getGender());
        patient.setDob(patientDTO.getDob());
        patient.setAddress(patientDTO.getAddress());
        patient.setContentNumber(patientDTO.getContentnumber());
        patient.setNote(patientDTO.getContentnumber());
        return patient;
    }
}
