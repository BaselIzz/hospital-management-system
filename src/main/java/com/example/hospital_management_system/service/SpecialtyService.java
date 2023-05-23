package com.example.hospital_management_system.service;


import com.example.hospital_management_system.Dto.SpecialtyDTO;
import java.util.List;

public interface SpecialtyService {
    List<SpecialtyDTO> getAllSpecialties();
    SpecialtyDTO getSpecialtyById(Long specialtyId);
    SpecialtyDTO createSpecialty(SpecialtyDTO specialtyDTO);
    SpecialtyDTO updateSpecialty(Long specialtyId, SpecialtyDTO specialtyDTO);
    void deleteSpecialty(Long specialtyId);
}
