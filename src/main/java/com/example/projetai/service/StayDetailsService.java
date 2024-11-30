package com.example.projetai.service;


import com.example.projetai.entities.StayDetails;
import com.example.projetai.repository.StayDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StayDetailsService {

    private final StayDetailsRepository stayDetailsRepository;

    public List<StayDetails> getAllStayDetails() {
        return stayDetailsRepository.findAll();
    }

    public Optional<StayDetails> getStayDetailsById(Long id) {
        return stayDetailsRepository.findById(id);
    }

    public StayDetails createStayDetails(StayDetails stayDetails) {
        return stayDetailsRepository.save(stayDetails);
    }

    public StayDetails updateStayDetails(Long id, StayDetails updatedStayDetails) {
        if (stayDetailsRepository.existsById(id)) {
            updatedStayDetails.setId(id);
            return stayDetailsRepository.save(updatedStayDetails);
        } else {
            throw new RuntimeException("StayDetails not found");
        }
    }

    public void deleteStayDetails(Long id) {
        if (stayDetailsRepository.existsById(id)) {
            stayDetailsRepository.deleteById(id);
        } else {
            throw new RuntimeException("StayDetails not found");
        }
    }
}
