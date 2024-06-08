package com.cosmos.blob;

import java.io.FileWriter;
import java.io.IOException;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * The service class responsible to connect to the BlobServiceClient and create containers/blobs
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class BlobOperationsService {
    /**
     * The data path to keep the uploaded files locally
     */
    private static final String PATH = "./data";
    /**
     * The container name to be created,
     */
    private static final String CONTAINER_NAME = "container07061905";
    private final BlobServiceClient blobServiceClient;

    public void createContainer() {
        log.debug("A container with name {} will be created", CONTAINER_NAME);
        blobServiceClient.createBlobContainerIfNotExists(CONTAINER_NAME);
        log.debug("A container with name {} has been created", CONTAINER_NAME);
    }

    public void uploadBlob(MultipartFile file) {

        FileWriter writer = null;
        try {
            writer = new FileWriter(PATH + file.getOriginalFilename(), true);
            writer.close();
            BlobContainerClient blobContainerClient = blobServiceClient.getBlobContainerClient(CONTAINER_NAME);
            BlobClient blobClient = blobContainerClient.getBlobClient(file.getOriginalFilename());
            // overrides content
            blobClient.uploadFromFile(PATH + "/" + file.getOriginalFilename(), true);
            log.debug("File written to blob successfully");
        } catch (IOException ex) {
            log.error("File can't be written {}", file.getOriginalFilename(), ex);
        }


    }
}
