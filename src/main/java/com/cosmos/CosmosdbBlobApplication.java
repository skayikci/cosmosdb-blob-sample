package com.cosmos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class CosmosdbBlobApplication {

    public static void main(String[] args) {
        SpringApplication.run(CosmosdbBlobApplication.class, args);
    }

}
