package com.example.audit.dto;

import lombok.Data;

@Data
public class AuditEventRequest {
    private String userId;
    private String actionType;
    private String entityType;
    private String entityId;
    private String sourceType;
}
