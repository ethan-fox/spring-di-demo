package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.datastore.IDatastoreDao;
import com.example.demo.model.EventPacket;
import com.example.demo.model.StorageResult;

@Service
public class EventStorageService {

    private final List<IDatastoreDao> datastores;
    
    public EventStorageService(List<IDatastoreDao> datastores) {
        this.datastores = datastores;
    }

    public List<StorageResult> persistEvent(EventPacket event) {
        return datastores.stream()
            .filter(datastore -> datastore.compatible(event))
            .map(datastore -> datastore.store(event))
            .toList();
    }
}
