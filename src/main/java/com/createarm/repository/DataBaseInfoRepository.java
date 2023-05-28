package com.createarm.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class DataBaseInfoRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DataBaseInfoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Collection<String> findAllTableNamesBySchema(String schema) {
        return jdbcTemplate.queryForList(
                "SELECT table_name FROM information_schema.tables WHERE table_type = 'BASE TABLE' AND table_schema = ?",
                String.class, schema);
    }

    public Collection<String> findAllTableFieldsByTableName(String tableName) {
        return jdbcTemplate.queryForList(
                "SELECT column_name FROM information_schema.columns WHERE table_name = ?",
                String.class, tableName);
    }

}
