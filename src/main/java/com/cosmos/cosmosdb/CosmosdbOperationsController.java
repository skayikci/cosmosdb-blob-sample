package com.cosmos.cosmosdb;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A simple REST controlle for basic Cosmosdb operations.
 */
@RestController
@RequestMapping("/v1/cosmosdb")
@RequiredArgsConstructor
public class CosmosdbOperationsController {

    private final CosmosdbOperationsService cosmosdbOperationsService;

    /**
     * Creates an item in the database.
     *
     * @param createRequest the request object
     * @return {@link CustomerCreateResponse} representing create operation result.
     */
    @PostMapping
    public ResponseEntity<CustomerCreateResponse> createItem(@RequestBody @Valid CustomerCreateRequest createRequest) {
        return ResponseEntity.ok(cosmosdbOperationsService.createItem(createRequest));
    }

    /**
     * Gets a customer by id.
     *
     * @param id the id of the object
     * @return {@link CustomerCreateResponse} representing get operation result.
     */
    @GetMapping("/{id}")
    public ResponseEntity<CustomerGetResponse> getItem(@PathVariable @NotBlank String id) {
        return ResponseEntity.ok(cosmosdbOperationsService.getItem(id));
    }

    /**
     * Gets all customers
     *
     * @return {@link CustomerGetAllResponse} representing get all operation result.
     */
    @GetMapping("/all")
    public ResponseEntity<CustomerGetAllResponse> getAll() {
        return ResponseEntity.ok(cosmosdbOperationsService.getAll());
    }

    /**
     * Gets all customers filtered by country
     *
     * @return {@link CustomerGetAllResponse} representing get all operation result.
     */
    @GetMapping("/country/{country}")
    public ResponseEntity<CustomerGetAllResponse> findAllByCountry(@PathVariable @NotBlank String country) {
        return ResponseEntity.ok(cosmosdbOperationsService.findAllByCountry(country));
    }
}
