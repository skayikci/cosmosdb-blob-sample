package com.cosmos.cosmosdb;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
/**
 * A dto class to hold response from the service layer for getting all customers.
 */
@Builder
@Getter
@Setter
public class CustomerGetAllResponse {
    List<CustomerGetResponse> customerGetResponses;
}
