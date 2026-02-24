package com.example.medicine_inventory.repository;

// ↓ 別フォルダにある Inventory クラスを使うためのインポート
import com.example.medicine_inventory.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

    // 基本的な保存・検索機能だけで十分なので、中身は空っぽでOKです。

}