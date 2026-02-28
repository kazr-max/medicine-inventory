package com.example.medicine_inventory.controller;

import com.example.medicine_inventory.entity.Medication;
import com.example.medicine_inventory.service.MedicationService; // Serviceをインポート
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.medicine_inventory.repository.MedicationRepository;

@RestController
@RequestMapping("/api/v1/medications")
public class MedicationController {

    @Autowired
    private MedicationService medicationService; // RepositoryではなくServiceを呼ぶ

    @Autowired
    private MedicationRepository medicationRepository; // GET用に残しておく

    @PostMapping
    public Medication createMedication(@RequestBody Medication medication) {
        // Service経由で登録（在庫作成ロジックも走る）
        return medicationService.registerMedication(medication);
    }

    @GetMapping("/user/{userId}")
    public List<Medication> getMedications(@PathVariable Integer userId) {
        return medicationRepository.findByUserId(userId);
    }
    // MedicationController.java に追記

    @DeleteMapping("/{id}")
    public void deleteMedication(@PathVariable Integer id) {
        medicationService.deleteMedication(id);
    }
}