package com.example.audit.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "audit_events")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    @Enumerated(EnumType.STRING)
    private ActionType actionType;

    private String entityType;
    private String entityId;

    @Enumerated(EnumType.STRING)
    private SourceType sourceType;

    private LocalDateTime createdAt;
}
