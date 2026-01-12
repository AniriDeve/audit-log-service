package com.example.audit.service;

import com.example.audit.dto.*;
import com.example.audit.exception.InvalidFilterException;
import com.example.audit.model.*;
import com.example.audit.repository.AuditEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuditEventServiceImpl implements AuditEventService {

    private final AuditEventRepository repository;

    @Override
    public AuditEventResponse record(AuditEventRequest request) {
        AuditEvent event = new AuditEvent(
                null,
                request.getUserId(),
                ActionType.valueOf(request.getActionType()),
                request.getEntityType(),
                request.getEntityId(),
                SourceType.valueOf(request.getSourceType()),
                LocalDateTime.now()
        );

        AuditEvent saved = repository.save(event);
        return map(saved);
    }

    @Override
    public Page<AuditEventResponse> findByUser(
            String userId,
            int page,
            int size
    ) {
        if (page < 0 || size <= 0) {
            throw new InvalidFilterException("Invalid pagination parameters");
        }

        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        return repository.findByUserId(userId, pageable)
                .map(this::map);
    }

    private AuditEventResponse map(AuditEvent event) {
        return new AuditEventResponse(
                event.getId(),
                event.getUserId(),
                event.getActionType().name(),
                event.getEntityType(),
                event.getEntityId(),
                event.getSourceType().name(),
                event.getCreatedAt()
        );
    }
}
