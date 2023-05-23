package com.example.hospital_management_system.repository;

import com.example.hospital_management_system.entity.Apointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Apointment,Long> {

}
