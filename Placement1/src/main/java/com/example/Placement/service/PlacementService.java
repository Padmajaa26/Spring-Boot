package com.example.Placement.service;

import com.example.Placement.model.Placement;
import com.example.Placement.repository.PlacementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlacementService {

    @Autowired
    private PlacementRepository placementRepository;

    public List<Placement> getAllPlacements() {
        return placementRepository.findAll();
    }

    public Optional<Placement> getPlacementById(Long id) {
        return placementRepository.findById(id);
    }

    public Placement savePlacement(Placement placement) {
        return placementRepository.save(placement);
    }

    public void deletePlacement(Long id) {
        placementRepository.deleteById(id);
    }
}
