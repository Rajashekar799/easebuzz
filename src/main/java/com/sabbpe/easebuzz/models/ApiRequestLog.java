package com.sabbpe.easebuzz.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "api_request_log")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiRequestLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clientKey;

    private String clientSalt;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String originalPlainRequestJson;

    private String hash;

    private String requestEasebuzzUrl;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String requestFullPayload;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String responseEasebuzzPayload;

    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
