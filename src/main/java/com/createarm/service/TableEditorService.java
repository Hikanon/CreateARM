package com.createarm.service;

import com.createarm.configuration.AppConfig;
import com.createarm.model.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TableEditorService {

    private final AppConfig appConfig;
    private final DatabaseService databaseService;

    @Autowired
    public TableEditorService(AppConfig appConfig, DatabaseService databaseService) {
        this.appConfig = appConfig;
        this.databaseService = databaseService;
    }

    public JpaRepository<BaseEntity, Integer> getJpaRepositoryByTableName(String tableName) {
        return appConfig.getJpaRepositoryByTableName(tableName);
    }

    public Collection<String> getAllTableFields(String tableName) {
        return databaseService.getAllTableFields(tableName);
    }

    public Collection<Integer> getAllTableId(String tableName) {
        return getJpaRepositoryByTableName(tableName).findAll(Sort.by("id"))
                .stream()
                .map(BaseEntity::getId)
                .toList();
    }

    public void saveEntity(String tableName, Object[] data, Collection<String> fields) {
        databaseService.saveEntity(tableName, data, fields);
    }

    public Collection<BaseEntity> getAllByTableName(String tableName) {
        return appConfig.getJpaRepositoryByTableName(tableName).findAll(Sort.by("id"));
    }

    public void deleteEntity(String tableName, int id) {
        databaseService.deleteEntity(tableName, id);
    }
}
