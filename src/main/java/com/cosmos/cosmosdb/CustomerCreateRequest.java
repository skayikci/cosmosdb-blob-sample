package com.cosmos.cosmosdb;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Record class keeping the information regarding the request being made to the api
 */
public record CustomerCreateRequest(@NotBlank String firstName, @NotBlank String lastName,
                                    @Email String emailAddress, @NotNull Integer countryCode, @NotNull Integer lineNumber,
                                    @NotBlank String address, @NotBlank String zipCode, @NotBlank String state,
                                    @CountryCode @NotBlank String country, @NotBlank String language,
                                    Boolean verified) {
}
