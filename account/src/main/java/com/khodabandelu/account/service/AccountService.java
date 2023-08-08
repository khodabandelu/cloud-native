package com.khodabandelu.account.service;

import com.khodabandelu.account.common.exception.AccountAlreadyExistsException;
import com.khodabandelu.account.common.exception.AccountNotFoundException;
import com.khodabandelu.account.domain.Account;
import com.khodabandelu.account.domain.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account findByAccountNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber).orElseThrow(() -> new AccountNotFoundException(accountNumber));
    }

    public Iterable<Account> findAll() {
        return accountRepository.findAll();
    }

    public void deleteByAccountNumber(String accountNumber) {
        accountRepository.deleteByAccountNumber(accountNumber);
    }

    public Account addAccountToCustomer(Account account) {
        if (accountRepository.existsByAccountNumber(account.accountNumber())) {
            throw new AccountAlreadyExistsException(account.accountNumber());
        } else {
            return accountRepository.save(account);
        }
    }

    public boolean existsByAccountNumber(String accountNumber) {
        return accountRepository.existsByAccountNumber(accountNumber);
    }

    public Account editAccountDetails(String accountNumber, Account account) {
        return accountRepository.findByAccountNumber(accountNumber).map(existingAccount -> {
            var accountToUpdate = new Account(existingAccount.accountNumber(), account.cif(), account.balance());
            return accountRepository.save(accountToUpdate);
        }).orElse(addAccountToCustomer(account));
    }

}
