package com.createarm.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;

@Configuration
public class AppConfig {

    private final Map<String, JpaRepository<?, Integer>> repositories;

    @Autowired
    public AppConfig(Map<String, JpaRepository<?, Integer>> repositories) {
        this.repositories = repositories;
    }

    public JpaRepository<?, Integer> getJpaRepositoryByTableName(String tableName) {
        String repositoryName = repositories.keySet().stream()
                .filter(r -> r.toLowerCase().contains(tableName))
                .findFirst()
                .orElseThrow();
        return repositories.get(repositoryName);
    }
}
