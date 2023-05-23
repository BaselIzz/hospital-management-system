package com.example.hospital_management_system.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Data
@Entity
@Table(name = "Apointment")
public class Apointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 @ManyToOne
 @JoinColumn(name = "doctor_id")
    private Doctor  doctor;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient  patient;
    @Column
    private String room;

    @Column
    private Date ApointmentDate;

    @Column
    private double cost;
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
