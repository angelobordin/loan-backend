package br.com.angelobordin.loan_calculator.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import jakarta.persistence.Entity;

@Entity
@Table(name = "loan")
public record Loan(
        @Id
        Long id,
        LocalDateTime data_emprestimo,
        String moeda,
        BigDecimal valor_obtido,
        LocalDateTime data_vencimento,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {
}
