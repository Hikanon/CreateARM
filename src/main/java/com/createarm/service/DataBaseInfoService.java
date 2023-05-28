package com.createarm.service;

import com.createarm.repository.DataBaseInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DataBaseInfoService {

    private final DataBaseInfoRepository dataBaseInfoRepository;

    @Autowired
    public DataBaseInfoService(DataBaseInfoRepository dataBaseInfoRepository) {
        this.dataBaseInfoRepository = dataBaseInfoRepository;
    }


    public Collection<String> getAllTables(String schema) {
        return dataBaseInfoRepository.findAllTableNamesBySchema(schema);
    }

    public Collection<String> getAllTableFields(String tableName) {
        return dataBaseInfoRepository.findAllTableFieldsByTableName(tableName);
    }
}
