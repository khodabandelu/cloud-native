package com.khodabandelu.account.data;

import com.khodabandelu.account.domain.Account;
import com.khodabandelu.account.domain.AccountRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class AccountRepositoryImpl implements AccountRepository {
    private static final ConcurrentHashMap<String, Account> accounts = new ConcurrentHashMap<>();

    @Override
    public Iterable<Account> findAll() {
        return accounts.values();
    }

    @Override
    public Optional<Account> findByAccountNumber(String accountNumber) {
        return existsByAccountNumber(accountNumber) ? Optional.of(accounts.get(accountNumber)) : Optional.empty();
    }

    @Override
    public Account save(Account account) {
        accounts.put(account.accountNumber(), account);
        return account;
    }

    @Override
    public void deleteByAccountNumber(String accountNumber) {
        accounts.remove(accountNumber);
    }

    @Override
    public boolean existsByAccountNumber(String accountNumber) {
        return accounts.get(accountNumber) != null;
    }
}
