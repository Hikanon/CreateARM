package com.createarm.service;

import com.createarm.model.DbTables;
import com.createarm.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TableService {

    private final TableRepository tableRepository;

    @Autowired
    public TableService(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    public Collection<DbTables> getAllTables() {
        return tableRepository.findAll();
    }
}
