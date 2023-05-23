package com.example.hospital_management_system.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SpecialtyDoctorDTO {
    private Long id;
    private Long  doctor;
    private Long specialty;


}
