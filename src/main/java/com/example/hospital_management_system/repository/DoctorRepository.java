package com.example.hospital_management_system.repository;

import com.example.hospital_management_system.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    @Query(value = "SELECT * FROM DOCTORS WHERE ID IN (SELECT ID FROM PATIENT_DOCTOR WHERE patient_id = :p)", nativeQuery = true)
    List<Doctor> getDoctorsByPatient(@Param("p") Long p);

}
