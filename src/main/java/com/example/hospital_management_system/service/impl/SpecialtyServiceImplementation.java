package com.example.hospital_management_system.service.impl;

import com.example.hospital_management_system.Dto.SpecialtyDTO;
import com.example.hospital_management_system.entity.Specialty;
import com.example.hospital_management_system.repository.SpecialtyRepository;
import com.example.hospital_management_system.service.SpecialtyService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpecialtyServiceImplementation implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialtyServiceImplementation(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public List<SpecialtyDTO> getAllSpecialties() {
        List<Specialty> specialties = specialtyRepository.findAll();
        return specialties.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SpecialtyDTO getSpecialtyById(Long specialtyId) {
        Specialty specialty = specialtyRepository.findById(specialtyId)
                .orElseThrow(() -> new ResourceAccessException("Specialty not found"));
        return mapToDTO(specialty);
    }

    @Override
    public SpecialtyDTO createSpecialty(SpecialtyDTO specialtyDTO) {
        Specialty specialty = mapToEntity(specialtyDTO);
        Specialty newSpecialty = specialtyRepository.save(specialty);
        return mapToDTO(newSpecialty);
    }

    @Override
    public SpecialtyDTO updateSpecialty(Long specialtyId, SpecialtyDTO specialtyDTO) {
        Specialty specialty = specialtyRepository.findById(specialtyId)
                .orElseThrow(() -> new ResourceAccessException("Specialty not found"));

        specialty.setName(specialtyDTO.getName());
        specialty.setDescription(specialtyDTO.getDescription());

        Specialty updatedSpecialty = specialtyRepository.save(specialty);
        return mapToDTO(updatedSpecialty);
    }

    @Override
    public void deleteSpecialty(Long specialtyId) {
        Specialty specialty = specialtyRepository.findById(specialtyId)
                .orElseThrow(() -> new ResourceAccessException("Specialty not found"));

        specialtyRepository.delete(specialty);
    }
    public SpecialtyDTO mapToDTO(Specialty specialty) {
        SpecialtyDTO specialtyDTO = new SpecialtyDTO();
        specialtyDTO.setId(specialty.getId());
        specialtyDTO.setName(specialty.getName());
        specialtyDTO.setDescription(specialty.getDescription());
        return specialtyDTO;
    }

    public Specialty mapToEntity(SpecialtyDTO specialtyDTO) {
        Specialty specialty = new Specialty();
//        specialty.setId(specialtyDTO.getId());
        specialty.setName(specialtyDTO.getName());
        specialty.setDescription(specialtyDTO.getDescription());
        return specialty;
    }
}
