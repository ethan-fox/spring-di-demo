package com.example.demo.dao.datastore;

import com.example.demo.model.EventPacket;
import com.example.demo.model.StorageResult;
import com.example.demo.model.enums.StorageType;

public interface IDatastoreDao {

    public StorageType getStorageType();
    
    public Boolean compatible(EventPacket eventPacket);

    public StorageResult store(EventPacket eventPacket);
}
