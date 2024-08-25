package br.com.angelobordin.loan_calculator.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author Angel
 */
public record Loan(
        Long id,
        LocalDateTime data_emprestimo,
        String moeda,
        BigDecimal valor_obtido,
        LocalDateTime data_vencimento,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {

}
