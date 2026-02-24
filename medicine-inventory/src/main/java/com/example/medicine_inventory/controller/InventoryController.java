package com.example.medicine_inventory.controller;

import com.example.medicine_inventory.entity.Inventory;
import com.example.medicine_inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/inventories")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    // 在庫数の更新（PUTリクエスト）
    @PutMapping("/{medicationId}")
    public Inventory updateInventory(
            @PathVariable Integer medicationId,
            @RequestBody Map<String, Integer> body) {

        // JSONの {"remaining_amount": 10} を受け取る
        Integer amount = body.get("remaining_amount");
        return inventoryService.updateRemainingAmount(medicationId, amount);
    }
}