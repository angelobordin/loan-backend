package br.com.angelobordin.loan_calculator.domain;

import java.time.LocalDateTime;

import br.com.angelobordin.loan_calculator.api.LoanRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author Angel
 */
public class LoanService {

    private final LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public Mono<Loan> create(LoanRequest loanRequest) {
        return loanRepository.save(
                new Loan(null,
                        loanRequest.data_emprestimo(),
                        loanRequest.moeda(),
                        loanRequest.valor_obtido(),
                        loanRequest.data_vencimento(),
                        null,
                        null));
    }

    public Mono<Loan> getLoanById(Long id) {
        return loanRepository.findById(id);
    }

    public Flux<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    public Mono<Loan> updateLoanById(Long id, LoanRequest loanDetails) {
        return loanRepository.findById(id)
                .flatMap(existingLoan -> {
                    Loan updatedLoan = new Loan(
                            existingLoan.id(),
                            loanDetails.data_emprestimo() != null ? loanDetails.data_emprestimo() : existingLoan.data_emprestimo(),
                            loanDetails.moeda() != null ? loanDetails.moeda() : existingLoan.moeda(),
                            loanDetails.valor_obtido() != null ? loanDetails.valor_obtido() : existingLoan.valor_obtido(),
                            loanDetails.data_vencimento() != null ? loanDetails.data_vencimento() : existingLoan.data_vencimento(),
                            existingLoan.createdAt(),
                            LocalDateTime.now()
                    );
                    System.out.println("UpdatedLoan" + updatedLoan);
                    return loanRepository.save(updatedLoan);
                });
    }

    public Mono<Void> deleteLoanById(Long id) {
        return loanRepository.deleteById(id);
    }
}
