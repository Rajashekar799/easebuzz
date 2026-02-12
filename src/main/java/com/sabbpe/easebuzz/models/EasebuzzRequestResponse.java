package com.sabbpe.easebuzz.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "easebuzz_payment_callback",
        indexes = {
                @Index(name = "idx_txn_id", columnList = "txnId"),
                @Index(name = "idx_payment_status", columnList = "paymentStatus")
        }
)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EasebuzzRequestResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String txnId;

    @Column(length = 100)
    private String easebuzzPaymentId;

    @Column(length = 20)
    private String amount;

    @Column(length = 20)
    private String status;

    @Column(length = 128)
    private String hash;

    @Column(length = 100)
    private String customerName;

    @Column(length = 150)
    private String email;

    @Column(length = 20)
    private String phone;

    @Column(length = 255)
    private String productInfo;

    @Column(length = 500)
    private String errorMessage;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String rawResponse;

    @Column(length = 50)
    private String gatewayMode;

    @Column(nullable = false)
    private Boolean hashValidated;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private PaymentStatus paymentStatus;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
