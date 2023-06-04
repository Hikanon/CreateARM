package com.createarm.controller;

import com.createarm.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Collection;

@Controller
public class DataBaseInfoController {

    private final DatabaseService databaseService;

    @Autowired
    public DataBaseInfoController(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public Collection<String> getAllTables(String schema) {
        return databaseService.getAllTables(schema);
    }
}
