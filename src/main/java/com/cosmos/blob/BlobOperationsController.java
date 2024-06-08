package com.cosmos.blob;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * A simple rest controller for BlobOperations
 */
@RestController
@RequestMapping("/v1/blob")
@RequiredArgsConstructor
public class BlobOperationsController {

    private final BlobOperationsService blobOperationsService;

    /**
     * Creates a blob container
     */
    @PostMapping("/container")
    public void createContainer() {
        blobOperationsService.createContainer();
    }

    /**
     * Uploads a blob to the container
     *
     * @param file the file to upload
     */
    @PostMapping("/file")
    public void uploadBlob(@RequestParam("file") MultipartFile file) {
        blobOperationsService.uploadBlob(file);
    }
}
