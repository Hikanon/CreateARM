package com.createarm.controller;

import com.createarm.model.DbTables;
import com.createarm.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Collection;

@Controller
public class TableController {

    private final TableService tableService;

    @Autowired
    public TableController(TableService tableService) {
        this.tableService = tableService;
    }

    public Collection<DbTables> getAllTables() {
        System.out.println("hehe");
        return tableService.getAllTables();
    }
}
