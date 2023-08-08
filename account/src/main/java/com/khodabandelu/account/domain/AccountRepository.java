package com.khodabandelu.account.domain;

import java.util.Optional;

public interface AccountRepository {

    Iterable<Account> findAll();

    Optional<Account> findByAccountNumber(String accountNumber);

    Account save(Account account);

    void deleteByAccountNumber(String accountNumber);

    boolean existsByAccountNumber(String accountNumber);

}
