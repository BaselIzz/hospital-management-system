package com.example.hospital_management_system.entity;

import com.example.hospital_management_system.enumm.Sex;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, name = "Gender")
    private Sex sex;

    @Column(name = "Date of Birth", nullable = false)
    private Date Dob;
    @Column(nullable = false)
    private String Address;
    @Column(nullable = false)
    private String ContentNumber;
    @Column
    private String note;
    @ManyToMany
    @JoinTable(name = "patient_doctor", joinColumns = @JoinColumn(name = "patient_id"), inverseJoinColumns = @JoinColumn(name = "doctor_id"))
    private List<Doctor> doctors;

}
