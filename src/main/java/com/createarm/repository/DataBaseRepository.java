package com.createarm.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collection;

@Repository
public class DataBaseRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DataBaseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Collection<String> findAllTableNamesBySchema(String schema) {
        return jdbcTemplate.queryForList(
                "SELECT table_name FROM information_schema.tables WHERE table_type = 'BASE TABLE' AND table_schema = ? ORDER BY table_name",
                String.class, schema);
    }

    public Collection<String> findAllTableFieldsByTableName(String tableName) {
        return jdbcTemplate.queryForList(
                "SELECT column_name FROM information_schema.columns WHERE table_name = ?",
                String.class, tableName);
    }

    //FIXME Что-нибудь поумнее придумать
    public void saveEntity(String tableName, Object[] data, Collection<String> fields) {
        StringBuilder query = new StringBuilder("INSERT INTO ");
        query
                .append(tableName)
                .append("(").append(fields.toString().replace("[", "").replace("]", "")).append(")")
                .append(" VALUES (");
        Arrays.stream(data).forEach(d -> query.append("'").append(d).append("',"));
        query.delete(query.length() - 1, query.length());
        query.append(") ")
                .append("ON CONFLICT(id) DO UPDATE SET ");
        int iter = 0;
        for (String field : fields) {
            if(iter != data.length - 1) {
                query.append(field).append(" = '").append(data[iter]).append("',");
            }
            else query.append(field).append(" = '").append(data[iter]).append("';");
            iter++;
        }
        jdbcTemplate.update(query.toString());
    }


    public void deleteEntity(String tableName, int id) {
        String query = "DELETE FROM " +
                tableName +
                " WHERE id = " +
                id;
        jdbcTemplate.update(query);
    }
}
