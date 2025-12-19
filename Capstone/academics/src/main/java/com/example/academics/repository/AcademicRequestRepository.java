package com.example.academics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.academics.model.AcademicRequest;

public interface AcademicRequestRepository
        extends JpaRepository<AcademicRequest, Long> {
}
