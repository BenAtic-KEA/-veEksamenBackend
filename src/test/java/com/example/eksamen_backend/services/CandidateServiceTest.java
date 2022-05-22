package com.example.eksamen_backend.services;

import com.example.eksamen_backend.dto.CandidateRequest;
import com.example.eksamen_backend.entities.Candidate;
import com.example.eksamen_backend.entities.Party;
import com.example.eksamen_backend.repositories.CandidateRepository;
import com.example.eksamen_backend.repositories.PartyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ActiveProfiles("test")
class CandidateServiceTest {

@Autowired
    CandidateRepository candidateRepository;
@Autowired
    PartyRepository partyRepository;

    CandidateService candidateService;

    static Party party1,party2;
    static Candidate candidate1,candidate2,candidate3;

    @BeforeEach()
        void setup(@Autowired CandidateRepository candidateRepository, @Autowired PartyRepository partyRepository) {
        candidateService = new CandidateService( candidateRepository, partyRepository);

        candidate1 = new Candidate("testName1");
        candidate2 = new Candidate("testName2");
        candidate3 = new Candidate("testName3");
        party1 = new Party("testParty1", "T");
        party2 = new Party("testParty2", "X");

        party1.addCandidate(candidate1);
        party1.addCandidate(candidate2);
        party2.addCandidate(candidate3);

        partyRepository.save(party1);
        partyRepository.save(party2);
    }

    @Test
    void addCandidate() {
        //Arrange
        CandidateRequest cr = new CandidateRequest("testPerson1", party1.getId());
        int candidateCountBefore, candidateCountAfter;
        Candidate testCandidate;
        int partyCountBefore, partyCountAfter;

        //Act
                //Before adding
        partyCountBefore = partyRepository.findAll().size();
        candidateCountBefore = candidateRepository.findAll().size();
                // adding
        candidateService.addCandidate(cr);
                // after adding
        candidateCountAfter = candidateRepository.findAll().size();
        testCandidate = candidateRepository.findByName("testPerson1");
        partyCountAfter = partyRepository.findAll().size();

        //Assert

        assertTrue(candidateCountBefore < candidateCountAfter);
        assertNotNull(testCandidate);
        assertEquals(party1.getName(),testCandidate.getParty().getName());
        assertEquals(partyCountBefore,partyCountAfter);


    }

    @Test
    void deleteCandidate() {

        //Arrange
        int candidateCountBefore, candidateCountAfter;
        //Act
        candidateCountBefore = candidateRepository.findAll().size();
        candidateService.deleteCandidate(candidate1.getId());
        candidateCountAfter = candidateRepository.findAll().size();

        //Assert

        assertTrue(candidateCountBefore > candidateCountAfter);
        assertEquals(candidate2.getName(),candidateRepository.findById(candidate2.getId()).get().getName());
        assertFalse(candidateRepository.existsById(candidate1.getId()));

    }
}