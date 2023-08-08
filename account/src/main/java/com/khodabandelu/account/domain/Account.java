package com.khodabandelu.account.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record Account(
        @NotBlank(message = "The Account Number must be defined")
        String accountNumber,
        @NotBlank(message = "The cif number must be defined")
        String cif,
        @NotNull(message = "The balance must be defined")
        @PositiveOrZero(message = "The balance must be positive or zero")
        BigDecimal balance
) {
}
