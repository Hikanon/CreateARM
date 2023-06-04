package com.createarm.service;

import com.createarm.repository.DataBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DatabaseService {

    private final DataBaseRepository dataBaseRepository;

    @Autowired
    public DatabaseService(DataBaseRepository dataBaseRepository) {
        this.dataBaseRepository = dataBaseRepository;
    }


    public Collection<String> getAllTables(String schema) {
        return dataBaseRepository.findAllTableNamesBySchema(schema);
    }

    public Collection<String> getAllTableFields(String tableName) {
        return dataBaseRepository.findAllTableFieldsByTableName(tableName);
    }

    public void saveEntity(String tableName, Object[] data, Collection<String> fields) {
        dataBaseRepository.saveEntity(tableName, data, fields);
    }

    public void deleteEntity(String tableName, int id) {
        dataBaseRepository.deleteEntity(tableName, id);
    }
}
