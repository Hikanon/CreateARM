package com.createarm;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CreateArmApplication {


    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> new SpringApplicationBuilder(CreateArmApplication.class)
                .headless(false)
                .web(WebApplicationType.NONE)
                .run(args));
    }


}