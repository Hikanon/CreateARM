package com.createarm.controller;

import com.createarm.model.BaseEntity;
import com.createarm.service.TableEditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Collection;

@Controller
public class TableEditorController {

    private final TableEditorService tableEditorService;

    @Autowired
    public TableEditorController(TableEditorService tableEditorService) {
        this.tableEditorService = tableEditorService;
    }

    public Collection<String> getAllTableFields(String tableName) {
        return tableEditorService.getAllTableFields(tableName);
    }

    public Collection<Integer> getAllTableId(String tableName) {
        return tableEditorService.getAllTableId(tableName);
    }

    public void saveEntity(String tableName, Object[] data, Collection<String> fields) {
        tableEditorService.saveEntity(tableName, data, fields);
    }

    public void deleteEntity(String tableName, int id) {
        tableEditorService.deleteEntity(tableName, id);
    }

    public Collection<BaseEntity> getAllByTableName(String tableName) {
        return tableEditorService.getAllByTableName(tableName);
    }


}
