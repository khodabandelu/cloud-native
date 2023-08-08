package com.khodabandelu.account.api;

import com.khodabandelu.account.domain.Account;
import com.khodabandelu.account.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    @GetExchange
    public Iterable<Account> get() {
        return accountService.findAll();
    }

    @GetMapping("{accountNumber}")
    public Account getByAccountNumber(@PathVariable String accountNumber) {
        return accountService.findByAccountNumber(accountNumber);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Account createAccount(@Valid @RequestBody Account account) {
        return accountService.addAccountToCustomer(account);
    }

    @PutMapping("{accountNumber}")
    public Account updateAccount(@PathVariable String accountNumber, @Valid @RequestBody Account account) {
        return accountService.editAccountDetails(accountNumber, account);
    }

    @DeleteMapping("{accountNumber}")
    public void deleteAccount(@PathVariable String accountNumber) {
        accountService.deleteByAccountNumber(accountNumber);
    }

}
