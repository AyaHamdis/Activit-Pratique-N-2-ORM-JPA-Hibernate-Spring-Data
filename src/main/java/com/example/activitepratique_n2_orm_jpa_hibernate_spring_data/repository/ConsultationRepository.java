package com.example.activitepratique_n2_orm_jpa_hibernate_spring_data.repository;

import com.example.activitepratique_n2_orm_jpa_hibernate_spring_data.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
