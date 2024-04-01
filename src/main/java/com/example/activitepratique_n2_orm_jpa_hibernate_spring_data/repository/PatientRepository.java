package com.example.activitepratique_n2_orm_jpa_hibernate_spring_data.repository;

import com.example.activitepratique_n2_orm_jpa_hibernate_spring_data.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
