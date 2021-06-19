package com.example.task5;

import com.example.task5.controller.response.AccountStatement;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class EndToEndTest {

    @Autowired
    private TestRestTemplate testRest;

    @Test
    void resultingAmountsShouldBeCorrect() {
        // when
        testRest.postForObject("http://localhost:8080/transactions", new HttpEntity<>("{ \"from\": 1, \"to\": 2, \"amount\": \"10.0\"}", jsonHeader()), String.class);
        testRest.postForObject("http://localhost:8080/transactions", new HttpEntity<>("{ \"from\": 2, \"to\": 1, \"amount\": \"30.0\"}", jsonHeader()), String.class);
        testRest.postForObject("http://localhost:8080/transactions", new HttpEntity<>("{ \"from\": 3, \"to\": 1, \"amount\": \"10.0\"}", jsonHeader()), String.class);

        // then
        AccountStatement wallet1 = testRest.getForObject("http://localhost:8080/wallets/1/statement", AccountStatement.class);
        AccountStatement wallet2 = testRest.getForObject("http://localhost:8080/wallets/2/statement", AccountStatement.class);

        assertEqual(new BigDecimal("153"), wallet1.getAmount());
        assertEqual(new BigDecimal("436"), wallet2.getAmount());

        assertEquals(3, wallet1.getTransactions().size());
        assertEquals(2, wallet2.getTransactions().size());
    }

    private void assertEqual(BigDecimal expected, BigDecimal actual) {
        if (expected.compareTo(actual) != 0) {
            throw new AssertionFailedError("expected: " + expected.toPlainString() + ", actual: " + actual.toPlainString(), expected, actual);
        }
    }

    private HttpHeaders jsonHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json;charset=UTF-8");
        return headers;
    }

}
