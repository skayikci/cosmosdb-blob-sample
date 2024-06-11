package com.cosmos.cosmosdb;

import lombok.Builder;

/**
 * A record class to hold customer create response from the service layer.
 */
@Builder
public record CustomerCreateResponse(String id, String firstName, String lastName) {
}
