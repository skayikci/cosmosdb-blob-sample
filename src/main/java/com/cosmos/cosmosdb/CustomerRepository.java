package com.cosmos.cosmosdb;


import java.util.List;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import org.springframework.stereotype.Repository;

/**
 * A repository class to perform CRUD operations on a CosmosDB
 */
@Repository
public interface CustomerRepository extends CosmosRepository<Customer, String> {

    /**
     * A custom method to filter customers by country.
     * Looks for exact match, and generates an sql similar to:
     * SELECT * FROM customer WHERE country = :country
     *
     * @param country the country to filter customers
     * @return a list of {@link Customer} objects
     */
    List<Customer> findCustomerByCountryIs(String country);
}
