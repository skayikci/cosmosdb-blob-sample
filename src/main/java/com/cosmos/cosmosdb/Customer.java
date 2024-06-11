package com.cosmos.cosmosdb;


import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

/**
 * Entity class holding customer information
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Container(containerName = "customers")
public class Customer {
    @Id
    @GeneratedValue
    private String id;
    private String firstName;
    private String lastName;
    private @Email String emailAddress;
    private Integer countryCode;
    private Integer lineNumber;
    private String address;
    private String zipCode;
    private String state;
    @CountryCode
    @PartitionKey
    private String country;
    private String language;
    private Boolean verified;
}
