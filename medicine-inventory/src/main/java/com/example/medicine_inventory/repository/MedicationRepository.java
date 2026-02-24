package com.example.medicine_inventory.repository;

// ↓ 別フォルダにある Medication クラスを使うためのインポート
import com.example.medicine_inventory.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Integer> {

    // 家族メンバー（userId）ごとに薬を絞り込むための特注メソッドです。
    // 名前をルール通りにするだけで、Springが勝手にSQLを作ってくれます。
    List<Medication> findByUserId(Integer userId);

}