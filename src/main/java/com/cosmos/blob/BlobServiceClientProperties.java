package com.cosmos.blob;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Properties used to create a BlobServiceClient Bean
 *
 * @param connectionStringWithSAS the created SAS connection string
 */
@ConfigurationProperties(prefix = "com.cosmos")
public record BlobServiceClientProperties(String connectionStringWithSAS) {
}
