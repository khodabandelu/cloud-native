package com.khodabandelu.account.common.exception;

public class AccountAlreadyExistsException extends RuntimeException {
    public AccountAlreadyExistsException(String accountNumber) {
        super("Account with account number " + accountNumber + " already exists.");
    }
}
