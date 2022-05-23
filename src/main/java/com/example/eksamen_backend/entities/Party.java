package com.example.eksamen_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Party {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String partyletter;

    @OneToMany(mappedBy = "party", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Set<Candidate> candidates = new HashSet<>();

    public Party(String name, String partyletter) {
        this.name = name;
        this.partyletter = partyletter;
    }

    public void addCandidate(Candidate candidate){
        this.candidates.add(candidate);
        candidate.setParty(this);
    }

    public void addCandidates(Set<Candidate> candidates){
        this.candidates.addAll(candidates);
        for (Candidate candidate : candidates) {
            candidate.setParty(this);
        }
    }
    public void removeCandidate(Candidate candidate){
        this.candidates.remove(candidate);
        candidate.setParty(null);
    }
    public void removeCandidates(Set<Candidate> candidates){
        this.candidates.removeAll(candidates);
        for (Candidate candidate : candidates) {
            candidate.setParty(null);
        }
    }
}

