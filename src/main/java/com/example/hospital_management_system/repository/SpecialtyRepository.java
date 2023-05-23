package com.example.hospital_management_system.repository;

import com.example.hospital_management_system.entity.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty,Long> {
}
