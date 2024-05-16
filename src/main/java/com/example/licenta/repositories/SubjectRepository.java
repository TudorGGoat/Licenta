package com.example.licenta.repositories;

import com.example.licenta.entities.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {
    // Putem adăuga metode suplimentare pentru interogări personalizate, dacă este necesar
}
