package com.example.hospital_management_system.service;

import com.example.hospital_management_system.Dto.DoctorDTO;

import java.util.List;

public interface DoctorService {
    List<DoctorDTO> getDoctorsforPatient(Long S);

    List<DoctorDTO> getAllDoctors();

    DoctorDTO getDoctorById(Long DoctorID);

    DoctorDTO createDoctor(DoctorDTO doctorDTO);

    DoctorDTO updateDoctor(Long doctorId, DoctorDTO doctorDTO);
    void deleteDoctor(Long DoctorID);

}
