package com.example.medicine_inventory.entity;

import jakarta.persistence.*; // これが重要！
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity // ★これ！これがないから「Not a managed type」と怒られます
@Table(name = "users") // Supabase上のテーブル名と合わせます
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;
}