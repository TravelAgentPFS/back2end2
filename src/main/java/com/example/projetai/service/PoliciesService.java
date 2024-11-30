package com.example.projetai.service;

import com.example.projetai.entities.Policies;
import com.example.projetai.repository.PoliciesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PoliciesService {

    private final PoliciesRepository policiesRepository;

    public List<Policies> getAllPolicies() {
        return policiesRepository.findAll();
    }

    public Optional<Policies> getPoliciesById(Long id) {
        return policiesRepository.findById(id);
    }

    public Policies createPolicies(Policies policies) {
        return policiesRepository.save(policies);
    }

    public Policies updatePolicies(Long id, Policies updatedPolicies) {
        if (policiesRepository.existsById(id)) {
            updatedPolicies.setId(id);
            return policiesRepository.save(updatedPolicies);
        } else {
            throw new RuntimeException("Policies not found");
        }
    }

    // Supprimer une politique
    public void deletePolicies(Long id) {
        if (policiesRepository.existsById(id)) {
            policiesRepository.deleteById(id);
        } else {
            throw new RuntimeException("Policies not found");
        }
    }
}
