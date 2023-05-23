package com.example.hospital_management_system.service.impl;

import com.example.hospital_management_system.Dto.DoctorDTO;
import com.example.hospital_management_system.Dto.SpecialtyDTO;
import com.example.hospital_management_system.Dto.SpecialtyDoctorDTO;
import com.example.hospital_management_system.entity.Doctor;
import com.example.hospital_management_system.entity.Specialty;
import com.example.hospital_management_system.entity.SpecialtyDoctor;
import com.example.hospital_management_system.repository.SpecialtyDoctorRepository;
import com.example.hospital_management_system.service.DoctorService;
import com.example.hospital_management_system.service.SpecialtyDoctorService;
import com.example.hospital_management_system.service.SpecialtyService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpecialtyDoctorServiceImpl implements SpecialtyDoctorService {
    private final SpecialtyDoctorRepository specialtyDoctorRepository;
private DoctorService doctorService;
private SpecialtyService specialtyService;

    public SpecialtyDoctorServiceImpl(SpecialtyDoctorRepository specialtyDoctorRepository, DoctorService doctorService,SpecialtyService specialtyService) {
        this.specialtyDoctorRepository = specialtyDoctorRepository;
        this.doctorService=doctorService;
        this.specialtyService=specialtyService;
    }

    @Override
    public List<SpecialtyDoctorDTO> getAllSpecialtyDoctors() {
        List<SpecialtyDoctor> specialtyDoctors = specialtyDoctorRepository.findAll();
        return specialtyDoctors.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SpecialtyDoctorDTO getSpecialtyDoctorById(Long specialtyDoctorId) {
        SpecialtyDoctor specialtyDoctor = specialtyDoctorRepository.findById(specialtyDoctorId)
                .orElseThrow(() -> new ResourceAccessException("SpecialtyDoctor"));
        return mapToDTO(specialtyDoctor);
    }

    @Override
    public SpecialtyDoctorDTO createSpecialtyDoctor(SpecialtyDoctorDTO specialtyDoctorDTO) {
        SpecialtyDoctor specialtyDoctor = mapToEntity(specialtyDoctorDTO);
        SpecialtyDoctor createdSpecialtyDoctor = specialtyDoctorRepository.save(specialtyDoctor);
        return mapToDTO(createdSpecialtyDoctor);
    }

    @Override
    public SpecialtyDoctorDTO updateSpecialtyDoctor(Long specialtyDoctorId, SpecialtyDoctorDTO specialtyDoctorDTO) {
        SpecialtyDoctor existingSpecialtyDoctor = specialtyDoctorRepository.findById(specialtyDoctorId)
                .orElseThrow(() -> new ResourceAccessException("SpecialtyDoctor"));

        existingSpecialtyDoctor.setDoctor(mapToEntitydoc(doctorService.getDoctorById(specialtyDoctorDTO.getDoctor())));
        existingSpecialtyDoctor.setSpecialty(mapToEntityspc(specialtyService.getSpecialtyById(specialtyDoctorDTO.getSpecialty())));

        SpecialtyDoctor updatedSpecialtyDoctor = specialtyDoctorRepository.save(existingSpecialtyDoctor);
        return mapToDTO(updatedSpecialtyDoctor);
    }

    @Override
    public void deleteSpecialtyDoctor(Long specialtyDoctorId) {
        SpecialtyDoctor specialtyDoctor = specialtyDoctorRepository.findById(specialtyDoctorId)
                .orElseThrow(() -> new ResourceAccessException("SpecialtyDoctor"));
        specialtyDoctorRepository.delete(specialtyDoctor);
    }
    public SpecialtyDoctorDTO mapToDTO(SpecialtyDoctor specialtyDoctor) {
        SpecialtyDoctorDTO specialtyDoctorDTO = new SpecialtyDoctorDTO();
        specialtyDoctorDTO.setId(specialtyDoctor.getId());
        specialtyDoctorDTO.setDoctor(specialtyDoctor.getDoctor().getID());
        specialtyDoctorDTO.setSpecialty(specialtyService.getSpecialtyById(specialtyDoctor.getSpecialty().getId()).getId());
        return specialtyDoctorDTO;
    }

    public SpecialtyDoctor mapToEntity(SpecialtyDoctorDTO specialtyDoctorDTO) {
        SpecialtyDoctor specialtyDoctor = new SpecialtyDoctor();
     //   specialtyDoctor.setId(specialtyDoctorDTO.getId());
        specialtyDoctor.setDoctor(mapToEntitydoc(doctorService.getDoctorById(specialtyDoctorDTO.getDoctor())));
        specialtyDoctor.setSpecialty(mapToEntityspc(specialtyService.getSpecialtyById(specialtyDoctorDTO.getSpecialty())));
        return specialtyDoctor;
    }
    public Doctor mapToEntitydoc(DoctorDTO doctorDTO) {
        Doctor doctor = new Doctor();
        doctor.setID(doctorDTO.getID());
        doctor.setName(doctorDTO.getName());
        doctor.setContentNumber(doctorDTO.getContentNumber());
        return doctor;
    }
    public SpecialtyDTO mapToDTOspc(Specialty specialty) {
        SpecialtyDTO specialtyDTO = new SpecialtyDTO();
        specialtyDTO.setId(specialty.getId());
        specialtyDTO.setName(specialty.getName());
        specialtyDTO.setDescription(specialty.getDescription());
        return specialtyDTO;
    }

    public Specialty mapToEntityspc(SpecialtyDTO specialtyDTO) {
        Specialty specialty = new Specialty();
        specialty.setId(specialtyDTO.getId());
        specialty.setName(specialtyDTO.getName());
        specialty.setDescription(specialtyDTO.getDescription());
        return specialty;
    }
    public DoctorDTO mapToDTODoc(Doctor doctor) {
        DoctorDTO doctorDTO = new DoctorDTO();
        doctorDTO.setID(doctor.getID());
        doctorDTO.setName(doctor.getName());
        doctorDTO.setContentNumber(doctor.getContentNumber());

        return doctorDTO;
    }
}
