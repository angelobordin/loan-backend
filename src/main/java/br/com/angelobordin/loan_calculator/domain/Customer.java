package br.com.angelobordin.loan_calculator.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.Entity;

@Entity
@Table(name = "customer")
public record Customer(
        @Id 
        Long id,
        String name,
        String cpf,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {
}
