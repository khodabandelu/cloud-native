package com.khodabandelu.account.common.exception;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String accountNumber) {
        super("The Account with account number " + accountNumber + " was not found");
    }
}
