package com.example.medicine_inventory.service;

import com.example.medicine_inventory.entity.Inventory;
import com.example.medicine_inventory.entity.Medication;
import com.example.medicine_inventory.repository.InventoryRepository;
import com.example.medicine_inventory.repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@Service // これで「ビジネスロジックを担当する部品」としてSpringに登録されます
public class MedicationService {

    @Autowired
    private MedicationRepository medicationRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    // お薬を登録し、同時に在庫レコードも作成する
    @Transactional // ★重要：どちらかの保存に失敗したら、全部ロールバック（取り消し）します
    public Medication registerMedication(Medication medication) {
        // 1. お薬情報を保存
        Medication savedMedication = medicationRepository.save(medication);

        // 2. その薬用の在庫レコードを「0個」で作成
        Inventory inventory = new Inventory();
        //inventory.setMedicationId(savedMedication.getId());
        inventory.setMedication(savedMedication);
        inventory.setRemainingAmount(0); // 初期在庫は0
        inventory.setUpdatedAt(OffsetDateTime.now());

        inventoryRepository.save(inventory);

        return savedMedication;
    }
    // MedicationService.java に追記

    @Transactional
    public void deleteMedication(Integer id) {
        // 在庫を先に消さなくても、DBの外部キー制約（Cascade）があれば一緒に消えますが、
        // 安全のためにプログラム側でも制御できます。
        if (medicationRepository.existsById(id)) {
            medicationRepository.deleteById(id);
        }
    }
}