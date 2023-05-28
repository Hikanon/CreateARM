package com.createarm.controller;

import com.createarm.service.DataBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Collection;

@Controller
public class DataBaseInfoController {

    private final DataBaseInfoService dataBaseInfoService;

    @Autowired
    public DataBaseInfoController(DataBaseInfoService dataBaseInfoService) {
        this.dataBaseInfoService = dataBaseInfoService;
    }

    public Collection<String> getAllTables(String schema) {
        return dataBaseInfoService.getAllTables(schema);
    }
}
