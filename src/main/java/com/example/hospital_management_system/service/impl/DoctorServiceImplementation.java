package com.example.hospital_management_system.service.impl;

import com.example.hospital_management_system.Dto.DoctorDTO;
import com.example.hospital_management_system.entity.Doctor;
import com.example.hospital_management_system.repository.DoctorRepository;
import com.example.hospital_management_system.service.DoctorService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImplementation implements DoctorService {
    final DoctorRepository doctorRepository;

    public DoctorServiceImplementation(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }


    @Override
    public List<DoctorDTO> getDoctorsforPatient(Long id ) {
        List<Doctor> doctors=doctorRepository.getDoctorsByPatient(id);

       return  doctors.stream()
               .map(this::mapToDTO)
               .collect(Collectors.toList());
    }
    @Override
    public List<DoctorDTO> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DoctorDTO getDoctorById(Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceAccessException("Doctor not found"));
        return mapToDTO(doctor);
    }

    @Override
    public DoctorDTO createDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = mapToEntity(doctorDTO);
        Doctor newDoctor = doctorRepository.save(doctor);
        return mapToDTO(newDoctor);
    }

    @Override
    public DoctorDTO updateDoctor(Long doctorId, DoctorDTO doctorDTO) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceAccessException("Doctor not found"));

        doctor.setName(doctorDTO.getName());
        doctor.setContentNumber(doctorDTO.getContentNumber());

        Doctor updatedDoctor = doctorRepository.save(doctor);
        return mapToDTO(updatedDoctor);
    }

    @Override
    public void deleteDoctor(Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceAccessException("Doctor not found"));

        doctorRepository.delete(doctor);
    }
    public DoctorDTO mapToDTO(Doctor doctor) {
        DoctorDTO doctorDTO = new DoctorDTO();
            doctorDTO.setID(doctor.getID());
        doctorDTO.setName(doctor.getName());
        doctorDTO.setContentNumber(doctor.getContentNumber());

        return doctorDTO;
    }

    // Map to entity
    public Doctor mapToEntity(DoctorDTO doctorDTO) {
        Doctor doctor = new Doctor();
        doctor.setID(doctorDTO.getID());
        doctor.setName(doctorDTO.getName());
        doctor.setContentNumber(doctorDTO.getContentNumber());
        return doctor;
    }
}
