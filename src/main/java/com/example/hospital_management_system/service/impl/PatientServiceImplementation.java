package com.example.hospital_management_system.service.impl;

import com.example.hospital_management_system.Dto.PatientDTO;
import com.example.hospital_management_system.entity.Patient;
import com.example.hospital_management_system.repository.PatientRepository;
import com.example.hospital_management_system.service.PatientService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImplementation implements PatientService {

    private final PatientRepository patientRepository;

    public PatientServiceImplementation(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<PatientDTO> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PatientDTO getPatientById(Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceAccessException("Patient not found"));
        return mapToDTO(patient);
    }

    @Override
    public PatientDTO createPatient(PatientDTO patientDTO) {
        Patient patient =mapToEntity(patientDTO);
        Patient newPatient = patientRepository.save(patient);
        return mapToDTO(newPatient);
    }

    @Override
    public PatientDTO updatePatient(Long patientId, PatientDTO patientDTO) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceAccessException("Patient not found"));

        patient.setName(patientDTO.getName());
        patient.setSex(patientDTO.getGender());
        patient.setDob(patientDTO.getDob());
        patient.setAddress(patientDTO.getAddress());
        patient.setContentNumber(patientDTO.getContentnumber());
        patient.setNote(patientDTO.getNote());

        Patient updatedPatient = patientRepository.save(patient);
        return mapToDTO(updatedPatient);
    }

    @Override
    public void deletePatient(Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceAccessException("Patient not found"));

        patientRepository.delete(patient);
    }
    public PatientDTO mapToDTO(Patient patient) {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setId(patient.getID());
        patientDTO.setName(patient.getName());
        patientDTO.setGender(patient.getSex());
        patientDTO.setDob(patient.getDob());
        patientDTO.setAddress(patient.getAddress());
        patientDTO.setContentnumber(patient.getContentNumber());
        patientDTO.setNote(patient.getNote());
        // Set doctors if needed
        // patientDTO.setDoctors(DoctorDTO.mapToDTOList(patient.getDoctors()));
        return patientDTO;
    }

    public Patient mapToEntity(PatientDTO patientDTO) {
        Patient patient = new Patient();
        patient.setID(patientDTO.getId());
        patient.setName(patientDTO.getName());
        patient.setSex(patientDTO.getGender());
        patient.setDob(patientDTO.getDob());
        patient.setAddress(patientDTO.getAddress());
        patient.setContentNumber(patientDTO.getContentnumber());
        patient.setNote(patientDTO.getContentnumber());
        // Set doctors if needed
       //  patient.setDoctors(mapToEntity(patientDTO));
        return patient;
    }
}
