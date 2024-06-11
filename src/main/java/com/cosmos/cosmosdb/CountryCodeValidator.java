package com.cosmos.cosmosdb;

import java.util.Locale;
import java.util.Set;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Validator class to check the fields and parameters if the given input is a valid country.
 */
public class CountryCodeValidator implements ConstraintValidator<CountryCode, String> {
    private static final Set<String> ISO_COUNTRIES = Set.of(Locale.getISOCountries());

    /**
     * Checks if the given input value is a valid country
     *
     * @param value object to validate
     * @param context context in which the constraint is evaluated
     *
     * @return true if value is a valid country code, else false
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return ISO_COUNTRIES.contains(value);
    }
}
