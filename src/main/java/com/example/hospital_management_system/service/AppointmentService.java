package com.example.hospital_management_system.service;

import com.example.hospital_management_system.Dto.AppointmentDTO;

import java.util.List;

public interface AppointmentService {



    List<AppointmentDTO> getAllAppointments();

    AppointmentDTO getAppointmentById(Long appointmentId);

    AppointmentDTO createAppointment(AppointmentDTO appointmentDTO);

    AppointmentDTO updateAppointment(Long appointmentId, AppointmentDTO appointmentDTO);
    void deleteAppointment(Long appointmentId);


}
