package com.createarm.repository;

import com.createarm.model.DbTables;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface TableRepository extends org.springframework.data.repository.Repository<DbTables, Integer> {

    @Query(value = "from DbTables as db where db.tableName not like 'db_tables'")
    Collection<DbTables> findAll();

}
