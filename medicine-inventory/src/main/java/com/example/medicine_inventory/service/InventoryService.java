package com.example.medicine_inventory.service;

import com.example.medicine_inventory.entity.Inventory;
import com.example.medicine_inventory.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Transactional
    public Inventory updateRemainingAmount(Integer medicationId, Integer newAmount) {
        // 1. 対象の在庫データを取得（なければエラー）
        Inventory inventory = inventoryRepository.findById(medicationId)
                .orElseThrow(() -> new RuntimeException("在庫が見つかりません ID: " + medicationId));

        // 2. 在庫数を更新
        inventory.setRemainingAmount(newAmount);
        inventory.setUpdatedAt(OffsetDateTime.now());

        // 3. 保存（JPAが自動的に UPDATE 文を発行します）
        return inventoryRepository.save(inventory);
    }
}