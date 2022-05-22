package com.example.eksamen_backend.dto;

import com.example.eksamen_backend.entities.Party;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CandidateRequest {

   private String name;
    private int partyId;

}
