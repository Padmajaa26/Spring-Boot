package com.example.Placement.controller;

import com.example.Placement.model.Placement;
import com.example.Placement.service.PlacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/placements")
public class PlacementController {

    @Autowired
    private PlacementService placementService;

    @GetMapping
    public List<Placement> getAllPlacements() {
        return placementService.getAllPlacements();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Placement> getPlacementById(@PathVariable Long id) {
        Optional<Placement> placement = placementService.getPlacementById(id);
        return placement.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Placement createPlacement(@RequestBody Placement placement) {
        return placementService.savePlacement(placement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Placement> updatePlacement(@PathVariable Long id, @RequestBody Placement placement) {
        if (placementService.getPlacementById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        placement.setId(id);
        return ResponseEntity.ok(placementService.savePlacement(placement));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlacement(@PathVariable Long id) {
        if (placementService.getPlacementById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        placementService.deletePlacement(id);
        return ResponseEntity.noContent().build();
    }
}
