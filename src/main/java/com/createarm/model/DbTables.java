package com.createarm.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "db_tables", schema = "public", catalog = "sessia")
public class DbTables {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "table_name")
    private String tableName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DbTables dbTables = (DbTables) o;
        return id == dbTables.id && Objects.equals(tableName, dbTables.tableName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tableName);
    }
}
