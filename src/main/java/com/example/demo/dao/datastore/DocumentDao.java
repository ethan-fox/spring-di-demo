package com.example.demo.dao.datastore;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.example.demo.model.EventPacket;
import com.example.demo.model.StorageResult;
import com.example.demo.model.enums.EventSource;
import com.example.demo.model.enums.StorageType;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DocumentDao implements IDatastoreDao {
    // Per statement of work, only store events with source B & C
    private static Set<EventSource> ALLOWED_EVENT_SOURCES = Set.of(EventSource.SOURCE_B, EventSource.SOURCE_C);

    public Boolean compatible(EventPacket eventPacket) {
        return ALLOWED_EVENT_SOURCES.contains(eventPacket.source());
    }

    public StorageResult store(EventPacket eventPacket) {
        log.info("Storing packet as document with ID '{}'", eventPacket.id());

        return StorageResult.builder()
            .stored(true)
            .type(this.getStorageType())
            .build();
    }

    public StorageType getStorageType() {
        return StorageType.DOCUMENT_DATABASE;
    }
}
