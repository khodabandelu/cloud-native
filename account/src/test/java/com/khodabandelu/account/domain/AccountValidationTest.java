package com.khodabandelu.account.domain;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


class AccountValidationTest {

    private static Validator validator;

    @BeforeAll
    static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void whenAllFieldsCorrectThenValidationSucceeds() {
        var account = new Account("10001", "900001", new BigDecimal(100000));
        Set<ConstraintViolation<Account>> constraintViolations = validator.validate(account);
        assertThat(constraintViolations).isEmpty();
    }

    @Test
    void whenAccountNumberIsMissedThenValidationFails() {
        var account = new Account("", "900001", new BigDecimal(100000));
        Set<ConstraintViolation<Account>> constraintViolations = validator.validate(account);
        assertThat(constraintViolations).hasSize(1);
        assertThat(constraintViolations.iterator().next().getMessage()).isEqualTo("The Account Number must be defined");
    }

    @Test
    void balance() {
    }
}