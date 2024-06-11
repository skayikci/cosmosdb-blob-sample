package com.cosmos.cosmosdb;

import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * The service class responsible to connect to the CustomerRepository and do CRUD operations on cosmosdb
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CosmosdbOperationsService {

    private static final CustomerCreateRequestToEntityMapper customerCreateRequestToEntityMapper = CustomerCreateRequestToEntityMapper.INSTANCE;

    private final CustomerRepository customerRepository;

    /**
     * Creates a customer.
     *
     * @param createRequest the request object of {@link CustomerCreateRequest} class
     * @return an object of {@link CustomerCreateResponse} class
     */
    public CustomerCreateResponse createItem(CustomerCreateRequest createRequest) {
        Customer customer = customerCreateRequestToEntityMapper.requestToEntity(createRequest);

       Customer dbResponse = customerRepository.save(customer);
       log.debug("Wrote customer to database {}", dbResponse);
       return CustomerCreateResponse.builder()
               .id(dbResponse.getId())
               .firstName(dbResponse.getFirstName())
               .lastName(dbResponse.getLastName())
               .build();
    }

    /**
     * Finds a customer for given id
     *
     * @param id the requested customer id
     * @return an object of {@link CustomerGetResponse} class
     */
    public CustomerGetResponse getItem(String id) {
        Customer foundCustomer = customerRepository.findById(id).orElseThrow();

        return CustomerGetResponse.builder()
                .firstName(foundCustomer.getFirstName())
                .lastName(foundCustomer.getLastName())
                .address(foundCustomer.getAddress())
                .build();
    }

    /**
     * Finds all customers in the database
     *
     * @return an object of {@link CustomerGetAllResponse} class
     */
    public CustomerGetAllResponse getAll() {
        Iterable<Customer> customers = customerRepository.findAll();
        List<CustomerGetResponse> customerGetResponses = new ArrayList<>();
        customers.forEach(customer -> customerGetResponses.add(
                new CustomerGetResponse(customer.getFirstName(),
                        customer.getLastName(),
                        customer.getAddress())));

        return CustomerGetAllResponse.builder()
                .customerGetResponses(customerGetResponses)
                .build();
    }

    /**
     * Finds all customers in the database filtered by country
     *
     * @param country the country to filter customers
     * @return an object of {@link CustomerGetAllResponse} class
     */
    public CustomerGetAllResponse findAllByCountry(String country) {
        Iterable<Customer> customers = customerRepository.findCustomerByCountryIs(country);
        List<CustomerGetResponse> customerGetResponses = new ArrayList<>();
        customers.forEach(customer -> customerGetResponses.add(
                new CustomerGetResponse(customer.getFirstName(),
                        customer.getLastName(),
                        customer.getAddress())));

        return CustomerGetAllResponse.builder()
                .customerGetResponses(customerGetResponses)
                .build();
    }
}
