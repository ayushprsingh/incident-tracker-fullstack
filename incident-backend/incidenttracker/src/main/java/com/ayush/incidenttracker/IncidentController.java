package com.ayush.incidenttracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/incidents")
@CrossOrigin
public class IncidentController {

    @Autowired
    private IncidentRepository repository;

    // CREATE INCIDENT
    @PostMapping
public Incident createIncident(@Valid @RequestBody Incident incident) {

        incident.setCreatedAt(LocalDateTime.now());
        incident.setUpdatedAt(LocalDateTime.now());
        return repository.save(incident);
    }

    // GET ALL INCIDENTS WITH PAGINATION
   @GetMapping
public Page<Incident> getAllIncidents(
        @RequestParam(required = false) String status,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size
) {
    Pageable pageable = PageRequest.of(page, size);

    if (status != null) {
        return repository.findByStatus(status, pageable);
    }

    return repository.findAll(pageable);
}


    // GET INCIDENT BY ID
    @GetMapping("/{id}")
    public Incident getIncidentById(@PathVariable String id) {
        return repository.findById(id).orElseThrow();
    }

    // UPDATE INCIDENT STATUS
    @PatchMapping("/{id}")
    public Incident updateIncident(@PathVariable String id,@RequestBody Incident updatedIncident) {

        Incident incident = repository.findById(id).orElseThrow();
        incident.setStatus(updatedIncident.getStatus());
        incident.setUpdatedAt(LocalDateTime.now());

        return repository.save(incident);  
    }
}
