package br.com.angelobordin.loan_calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class LoanCalculatorApplicationTests {

    @Autowired
    WebTestClient webTestClient;

    /**
     * Teste de demonstração
     */
    @Test
    public void testCreateLoanSucess() {
        String name = "teste";
        webTestClient.post().uri("/loans").bodyValue(null).exchange().expectBody().jsonPath("name", name);
    }

    @Test
    public void testCreateLoanFailed() {
        webTestClient.post().uri("/loans").bodyValue(null).exchange().expectStatus().isBadRequest();
    }
}
