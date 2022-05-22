package com.example.eksamen_backend.repositories;

import com.example.eksamen_backend.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
    public Candidate findByName(String name);

}
