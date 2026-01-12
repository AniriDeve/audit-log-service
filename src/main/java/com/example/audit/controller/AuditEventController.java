package com.example.audit.controller;

import com.example.audit.dto.*;
import com.example.audit.service.AuditEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/audit")
@RequiredArgsConstructor
public class AuditEventController {

    private final AuditEventService service;

    @PostMapping
    public AuditEventResponse record(
            @RequestBody AuditEventRequest request
    ) {
        return service.record(request);
    }

    @GetMapping
    public Page<AuditEventResponse> byUser(
            @RequestParam String userId,
            @RequestParam int page,
            @RequestParam int size
    ) {
        return service.findByUser(userId, page, size);
    }
}
