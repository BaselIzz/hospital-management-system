package com.example.hospital_management_system.service;

import com.example.hospital_management_system.Dto.SpecialtyDoctorDTO;

import java.util.List;

public interface SpecialtyDoctorService {
    List<SpecialtyDoctorDTO> getAllSpecialtyDoctors();

    SpecialtyDoctorDTO getSpecialtyDoctorById(Long specialtyDoctorId);

    SpecialtyDoctorDTO createSpecialtyDoctor(SpecialtyDoctorDTO specialtyDoctorDTO);

    SpecialtyDoctorDTO updateSpecialtyDoctor(Long specialtyDoctorId, SpecialtyDoctorDTO specialtyDoctorDTO);

    void deleteSpecialtyDoctor(Long specialtyDoctorId);
}
