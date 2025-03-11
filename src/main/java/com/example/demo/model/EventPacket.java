package com.example.demo.model;

import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

import com.example.demo.model.enums.EventSource;

public record EventPacket(
    UUID id,
    EventSource source,
    LocalDate date,
    Map<String, String> metadata
) {
    
}
