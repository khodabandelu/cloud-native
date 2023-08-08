package com.khodabandelu.account.api;

import com.khodabandelu.account.common.exception.AccountNotFoundException;
import com.khodabandelu.account.service.AccountService;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AccountController.class)
class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    @Test
    void whenGetAccountNotExistingThenShouldReturn404() throws Exception {
        String accountNumber = "100001";
        BDDMockito.given(accountService.findByAccountNumber(accountNumber)).willThrow(AccountNotFoundException.class);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/accounts/" + accountNumber))
                .andExpect(status().isNotFound());
    }
}