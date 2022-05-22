package com.example.eksamen_backend.repositories;

import com.example.eksamen_backend.entities.Party;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface PartyRepository extends JpaRepository<Party, Integer> {

}
