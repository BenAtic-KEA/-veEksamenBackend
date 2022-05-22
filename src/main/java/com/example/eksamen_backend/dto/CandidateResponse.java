package com.example.eksamen_backend.dto;

import com.example.eksamen_backend.entities.Candidate;
import com.example.eksamen_backend.entities.Party;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CandidateResponse {

    private int id;
    private String name;
    private PartyResponse partyResponse;

    public CandidateResponse(Candidate body) {
    this.id = body.getId();
    this.name = body.getName();
    this.partyResponse = new PartyResponse(body.getParty().getId(), body.getParty().getName(),body.getParty().getPartyletter());
    }
}
