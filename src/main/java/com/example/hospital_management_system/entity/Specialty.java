package com.example.hospital_management_system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "specialties")
@RequiredArgsConstructor
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    @NonNull
    private String description;
    @OneToMany(mappedBy = "specialty")
    private List<SpecialtyDoctor> specialtyDoctors;
    @Column(nullable = false)
    @NonNull
    private String name;



}
