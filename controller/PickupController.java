package com.waste.waste_management.controller;

import com.waste.waste_management.domain.Pickup;
import com.waste.waste_management.service.PickupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pickups")
@RequiredArgsConstructor
public class PickupController {

    private final PickupService pickupService;

    // Create new pickup
    @PostMapping
    public ResponseEntity<Pickup> createPickup(@RequestBody Pickup pickup) {
        return ResponseEntity.ok(pickupService.savePickup(pickup));
    }

    // Get all pickups
    @GetMapping
    public ResponseEntity<List<Pickup>> getAllPickups() {
        return ResponseEntity.ok(pickupService.getAllPickups());
    }

    // Get pickup by ID
    @GetMapping("/{id}")
    public ResponseEntity<Pickup> getPickupById(@PathVariable Long id) {
        return pickupService.getPickupById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete pickup
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePickup(@PathVariable Long id) {
        pickupService.deletePickup(id);
        return ResponseEntity.noContent().build();
    }

    // Get pickups by area
    @GetMapping("/area/{areaId}")
    public ResponseEntity<List<Pickup>> getPickupsByArea(@PathVariable Long areaId) {
        return ResponseEntity.ok(pickupService.getPickupsByArea(areaId));
    }

    // Get pickups by completion status
    @GetMapping("/status/{completed}")
    public ResponseEntity<List<Pickup>> getPickupsByStatus(@PathVariable boolean completed) {
        return ResponseEntity.ok(pickupService.getPickupsByCompletionStatus(completed));
    }
}
