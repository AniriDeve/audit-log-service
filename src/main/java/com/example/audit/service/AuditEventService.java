package com.example.audit.service;

import com.example.audit.dto.*;
import org.springframework.data.domain.Page;

public interface AuditEventService {

    AuditEventResponse record(AuditEventRequest request);

    Page<AuditEventResponse> findByUser(
            String userId,
            int page,
            int size
    );
}
