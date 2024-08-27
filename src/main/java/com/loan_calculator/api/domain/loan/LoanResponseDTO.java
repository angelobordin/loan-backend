package com.loan_calculator.api.domain.loan;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.loan_calculator.api.domain.customer.Customer;

public record LoanResponseDTO(Long id, LocalDateTime dataEmprestimo, String moeda, BigDecimal valorObtido, LocalDateTime dataVencimento, Customer customer) {

}
