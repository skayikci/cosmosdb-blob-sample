package com.cosmos.blob;

import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class to create BlobServiceClient.
 */
@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(BlobServiceClientProperties.class)
public class BlobConfiguration {

    private final BlobServiceClientProperties blobServiceClientProperties;


    @Bean
    public BlobServiceClient blobServiceClient() {
        return new BlobServiceClientBuilder()
                .connectionString(blobServiceClientProperties.connectionStringWithSAS())
                .buildClient();
    }
}
