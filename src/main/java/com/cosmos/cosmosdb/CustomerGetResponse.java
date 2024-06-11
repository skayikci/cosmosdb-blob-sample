package com.cosmos.cosmosdb;

import lombok.Builder;
/**
 * A record class to hold response from the service layer having customers.
 */
@Builder
public record CustomerGetResponse(String firstName, String lastName, String address) {
}
