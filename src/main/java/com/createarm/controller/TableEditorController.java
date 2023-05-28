package com.createarm.controller;

import com.createarm.configuration.AppConfig;
import com.createarm.model.BaseEntity;
import com.createarm.service.DataBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

import java.util.Collection;

@Controller
public class TableEditorController {

    private final AppConfig appConfig;
    private final DataBaseInfoService dataBaseInfoService;

    @Autowired
    public TableEditorController(AppConfig appConfig, DataBaseInfoService dataBaseInfoService) {
        this.appConfig = appConfig;
        this.dataBaseInfoService = dataBaseInfoService;
    }

    public AppConfig getAppConfig() {
        return appConfig;
    }

    public DataBaseInfoService getDataBaseInfoService() {
        return dataBaseInfoService;
    }

    public JpaRepository<BaseEntity, Integer> getJpaRepositoryByTableName(String tableName) {
        return appConfig.getJpaRepositoryByTableName(tableName);
    }

    public Collection<String> getAllTableFields(String tableName) {
        return dataBaseInfoService.getAllTableFields(tableName);
    }
}
