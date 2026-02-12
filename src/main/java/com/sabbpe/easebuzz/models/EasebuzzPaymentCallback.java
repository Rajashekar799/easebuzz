package com.sabbpe.easebuzz.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "easebuzz_payment_callback")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EasebuzzPaymentCallback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "txn_id", length = 100)
    private String txnId;

    @Column(length = 50)
    private String amount;

    @Column(length = 50)
    private String status;

    @Column(name = "payment_status", length = 50)
    private String paymentStatus;

    @Column(name = "customer_name", length = 100)
    private String customerName;

    @Column(length = 100)
    private String email;

    @Column(length = 20)
    private String phone;

    @Column(name = "gateway_mode", length = 50)
    private String gatewayMode;

    @Column(length = 255)
    private String hash;

    @Column(name = "hash_validated")
    private Boolean hashValidated;

    @Lob
    @Column(name = "raw_response", columnDefinition = "TEXT")
    private String rawResponse;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
