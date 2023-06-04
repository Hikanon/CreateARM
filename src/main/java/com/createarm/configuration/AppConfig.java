package com.createarm.configuration;

import com.createarm.model.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.Objects;

@Configuration
public class AppConfig {

    private final Map<String, JpaRepository<?, Integer>> repositories;

    @Autowired
    public AppConfig(Map<String, JpaRepository<?, Integer>> repositories) {
        this.repositories = repositories;
    }

    @SuppressWarnings("unchecked")
    public final JpaRepository<BaseEntity, Integer> getJpaRepositoryByTableName(String tableName) {
        String repositoryName = repositories.keySet().stream()
                .filter(r -> r.toLowerCase().contains(tableName))
                .findFirst()
                .orElseThrow();
        return (JpaRepository<BaseEntity, Integer>) repositories.get(repositoryName);
    }

    public static Image getImage() {
        return new ImageIcon(Objects.requireNonNull(AppConfig.class.getResource("/icon.png"))).getImage();
    }
}
