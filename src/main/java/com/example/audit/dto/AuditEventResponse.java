package com.example.audit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class AuditEventResponse {
    private Long id;
    private String userId;
    private String actionType;
    private String entityType;
    private String entityId;
    private String sourceType;
    private LocalDateTime createdAt;
}
