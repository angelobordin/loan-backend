package br.com.angelobordin.loan_calculator.domain;

import br.com.angelobordin.loan_calculator.api.LoanRequest;
import reactor.core.publisher.Mono;

/**
 *
 * @author Angel
 */
public class LoanService {

    private LoanRepository loanRepository;

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

}
