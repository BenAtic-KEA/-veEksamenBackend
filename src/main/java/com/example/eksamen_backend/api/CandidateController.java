package com.example.eksamen_backend.api;

import com.example.eksamen_backend.dto.CandidateRequest;
import com.example.eksamen_backend.dto.CandidateResponse;
import com.example.eksamen_backend.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/candidates")
public class CandidateController {

    CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("/{id}")
    public CandidateResponse getCandidate(@PathVariable int id) {
        return candidateService.getCandidate(id);
    }

    @GetMapping()
    public List<CandidateResponse> getCandidates() {
        return candidateService.getCandidates();
    }

    @PostMapping()
    public void addCandidate(@RequestBody CandidateRequest candidate) {
        candidateService.addCandidate(candidate);
    }



}
