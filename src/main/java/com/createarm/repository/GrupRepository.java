package com.createarm.repository;

import com.createarm.model.Grup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupRepository extends JpaRepository<Grup, Integer> {
}
