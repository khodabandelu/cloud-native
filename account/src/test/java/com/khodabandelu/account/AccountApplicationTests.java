package com.khodabandelu.account;

import com.khodabandelu.account.domain.Account;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.math.BigDecimal;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AccountApplicationTests {

    @Autowired
    WebTestClient webTestClient;

    @Test
    void contextLoads() {
    }

    @Test
    void whenPostRequestThenAccountCreated() {
        var expectedAccount = new Account("10001", "900001", new BigDecimal(10000));
        webTestClient.post()
                .uri("/api/accounts")
                .bodyValue(expectedAccount)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(Account.class).value(actualAccount -> {
                    Assertions.assertThat(actualAccount).isNotNull();
                    Assertions.assertThat(actualAccount.accountNumber()).isEqualTo(expectedAccount.accountNumber());
                });
    }

}
