package br.com.angelobordin.loan_calculator.api;

import java.time.LocalDateTime;

public record CustomerResponse(String name, String cpf, LocalDateTime createdAt, LocalDateTime updatedAt) {

}
