package com.cosmos.cosmosdb;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * A map_struct class responsible for mapping a {@link CustomerCreateRequest} to a {@link Customer} class.
 */
@Mapper
public interface CustomerCreateRequestToEntityMapper {
    CustomerCreateRequestToEntityMapper INSTANCE = Mappers.getMapper(CustomerCreateRequestToEntityMapper.class);

    Customer requestToEntity(CustomerCreateRequest request);
}
