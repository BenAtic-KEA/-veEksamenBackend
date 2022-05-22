package com.example.eksamen_backend.services;

import com.example.eksamen_backend.dto.CandidateRequest;
import com.example.eksamen_backend.dto.CandidateResponse;
import com.example.eksamen_backend.entities.Candidate;
import com.example.eksamen_backend.entities.Party;
import com.example.eksamen_backend.repositories.CandidateRepository;
import com.example.eksamen_backend.repositories.PartyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidateService {

    CandidateRepository candidateRepository;

    PartyRepository partyRepository;

    public CandidateService(CandidateRepository candidateRepository, PartyRepository partyRepository) {
        this.candidateRepository = candidateRepository;
        this.partyRepository = partyRepository;
    }
    public CandidateResponse getCandidate(int id) {
        return new CandidateResponse(candidateRepository.findById(id).orElseThrow(()-> new RuntimeException() ));
    }


    public List<CandidateResponse> getCandidates() {

        return candidateRepository.findAll().stream().map(candidate-> new CandidateResponse(candidate)).collect(Collectors.toList());
    }

    public void addCandidate(CandidateRequest candidate) {
    Candidate c = new Candidate(candidate.getName());
    Party p = partyRepository.findById(candidate.getPartyId()).orElseThrow(()-> new RuntimeException());
    p.addCandidate(c);
        candidateRepository.save(c);
    }
}
