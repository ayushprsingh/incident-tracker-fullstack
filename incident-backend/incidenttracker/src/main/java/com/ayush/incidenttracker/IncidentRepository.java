package com.ayush.incidenttracker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IncidentRepository extends JpaRepository<Incident, String> {

    Page<Incident> findByStatus(String status, Pageable pageable);

}
