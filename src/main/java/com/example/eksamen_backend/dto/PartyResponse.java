package com.example.eksamen_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PartyResponse {
    private int id;
    private String name;
    private String letter;
}
