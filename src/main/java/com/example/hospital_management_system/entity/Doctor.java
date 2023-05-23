package com.example.hospital_management_system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Doctors")
@RequiredArgsConstructor

public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private   Long ID;
    @Column(nullable = false,name = "DName")
    @NonNull
    private String Name;
    @Column(name = "DoctorCNumber")
    @NonNull
    private String ContentNumber;
    @OneToMany(mappedBy = "doctor")
    private List<SpecialtyDoctor> specialtyDoctors;


    @ManyToMany
    @JoinTable(
            name = "patient_doctor",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id")
    )
    private List<Doctor> Patient;
}
