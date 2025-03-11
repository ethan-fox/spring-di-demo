package com.example.demo.model;

import com.example.demo.model.enums.StorageType;

import lombok.Builder;

@Builder
public record StorageResult(
    StorageType type,
    Boolean stored
) {
    
}
