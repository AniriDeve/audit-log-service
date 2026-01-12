package com.example.audit.repository;

import com.example.audit.model.AuditEvent;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditEventRepository
        extends JpaRepository<AuditEvent, Long> {

    Page<AuditEvent> findByUserId(
            String userId,
            Pageable pageable
    );
}
