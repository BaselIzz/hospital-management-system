package com.example.hospital_management_system.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class SpecialtyDoctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @NonNull
    @JoinColumn(name = "doctor_id")
    private Doctor  doctor;
    @ManyToOne
    @NotNull
    @JoinColumn(name = "specialty_id")
    private Specialty specialty;
}
