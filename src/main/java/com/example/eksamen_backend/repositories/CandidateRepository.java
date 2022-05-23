package com.example.eksamen_backend.repositories;

import com.example.eksamen_backend.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
    public Candidate findByName(String name);

    public List<Candidate> findCandidatesByParty_Partyletter(String partyletter);

}
