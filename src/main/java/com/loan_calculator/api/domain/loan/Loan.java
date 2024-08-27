package com.loan_calculator.api.domain.loan;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.loan_calculator.api.domain.customer.Customer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "loan")
public class Loan {
    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime dataEmprestimo;

    private String moeda;

    private BigDecimal valorObtido;

    private LocalDateTime dataVencimento;
    
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
