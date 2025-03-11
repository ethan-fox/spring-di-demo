package com.example.demo.dao.datastore;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.example.demo.model.EventPacket;
import com.example.demo.model.StorageResult;
import com.example.demo.model.enums.StorageType;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DatabaseDao implements IDatastoreDao {
    
    // Events from prior to 2023 are not required per statement of work (e.g.)
    private static LocalDate ALLOWED_DATE_LOWER_THRESHOLD = LocalDate.of(2023, 1, 1);
    
    public Boolean compatible(EventPacket eventPacket) {
        return eventPacket.date().isAfter(ALLOWED_DATE_LOWER_THRESHOLD);
    }

    public StorageResult store(EventPacket eventPacket) {
        log.info("Storing packet as DB entry with ID '{}'", eventPacket.id());

        return StorageResult.builder()
            .stored(true)
            .type(this.getStorageType())
            .build();
    }

    public StorageType getStorageType() {
        return StorageType.RELATIONAL_DATABASE;
    }
}
