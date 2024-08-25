package br.com.angelobordin.loan_calculator.api;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record LoanRequest(LocalDateTime data_emprestimo, String moeda, BigDecimal valor_obtido, LocalDateTime data_vencimento) {

}
