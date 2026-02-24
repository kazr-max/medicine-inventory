package com.example.medicine_inventory.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "medications")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id", nullable = false)
    @JsonProperty("user_id") // ← JSONでは "user_id" という名前で受け取る
    private Integer userId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String type;

    @Column(name = "alert_threshold", nullable = false)
    @JsonProperty("alert_threshold") // ← JSONでは "alert_threshold" という名前で受け取る
    private Integer alertThreshold;
}