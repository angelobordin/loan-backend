package br.com.angelobordin.loan_calculator.domain;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface LoanRepository extends ReactiveCrudRepository<Loan, Long> {
}
