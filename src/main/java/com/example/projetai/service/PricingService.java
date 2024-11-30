package com.example.projetai.service;

import com.example.projetai.entities.Pricing;
import com.example.projetai.repository.PricingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PricingService {

    private final PricingRepository pricingRepository;

    public List<Pricing> getAllPricing() {
        return pricingRepository.findAll();
    }

    public Optional<Pricing> getPricingById(Long id) {
        return pricingRepository.findById(id);
    }

    public Pricing createPricing(Pricing pricing) {
        return pricingRepository.save(pricing);
    }

    public Pricing updatePricing(Long id, Pricing updatedPricing) {
        if (pricingRepository.existsById(id)) {
            updatedPricing.setId(id);
            return pricingRepository.save(updatedPricing);
        } else {
            throw new RuntimeException("Pricing not found");
        }
    }

    public void deletePricing(Long id) {
        if (pricingRepository.existsById(id)) {
            pricingRepository.deleteById(id);
        } else {
            throw new RuntimeException("Pricing not found");
        }
    }
}
