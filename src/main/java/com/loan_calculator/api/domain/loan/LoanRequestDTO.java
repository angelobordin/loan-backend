package com.loan_calculator.api.domain.loan;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record LoanRequestDTO(LocalDateTime dataEmprestimo, String moeda, BigDecimal valorObtido, LocalDateTime dataVencimento, Long customer_id) {

}