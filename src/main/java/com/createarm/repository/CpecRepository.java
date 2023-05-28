package com.createarm.repository;

import com.createarm.model.Cpec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CpecRepository extends JpaRepository<Cpec, Integer> {
}
