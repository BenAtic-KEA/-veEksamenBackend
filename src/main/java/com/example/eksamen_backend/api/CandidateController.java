package com.example.eksamen_backend.api;

import com.example.eksamen_backend.dto.CandidateRequest;
import com.example.eksamen_backend.dto.CandidateResponse;
import com.example.eksamen_backend.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
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

    @PutMapping("/{id}")
    public CandidateResponse updateCandidate(@PathVariable int id, @RequestBody CandidateRequest candidate) {
        return candidateService.updateCandidate(id, candidate);
    }
    @DeleteMapping("/{id}")
    public void deleteCandidate(@PathVariable int id) {
        candidateService.deleteCandidate(id);
    }

}
