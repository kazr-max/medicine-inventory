package com.example.medicine_inventory.repository;

// ↓ 他のフォルダ（entity）にある User クラスを使うための「住所」です
import com.example.medicine_inventory.entity.User;
// ↓ Spring Data JPA の基本機能を使うためのインポートです
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // 継承（extends）を書いたので、中身は空っぽで大丈夫です！
}