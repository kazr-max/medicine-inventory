package com.example.medicine_inventory.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.OffsetDateTime;

@Entity
@Table(name = "inventories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {
    @Id
    @Column(name = "medication_id")
    private Integer medicationId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "medication_id")
    private Medication medication;

    @Column(name = "remaining_amount", nullable = false)
    private Integer remainingAmount;

    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt = OffsetDateTime.now();

    @PreUpdate
    @PrePersist
    protected void onUpdate() {
        updatedAt = OffsetDateTime.now();
    }
}