package com.example.hospital_management_system.service;

import com.example.hospital_management_system.Dto.PatientDTO;
import java.util.List;

public interface PatientService {
    List<PatientDTO> getAllPatients();
    PatientDTO getPatientById(Long patientId);
    PatientDTO createPatient(PatientDTO patientDTO);
    PatientDTO updatePatient(Long patientId, PatientDTO patientDTO);
    void deletePatient(Long patientId);
}
