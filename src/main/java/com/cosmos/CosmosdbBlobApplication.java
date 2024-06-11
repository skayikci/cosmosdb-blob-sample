package com.cosmos;

import com.azure.spring.data.cosmos.repository.config.EnableCosmosRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EnableCosmosRepositories
public class CosmosdbBlobApplication {

    public static void main(String[] args) {
        SpringApplication.run(CosmosdbBlobApplication.class, args);
    }

}
