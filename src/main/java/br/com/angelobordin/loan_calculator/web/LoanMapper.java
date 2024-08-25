package br.com.angelobordin.loan_calculator.web;

import br.com.angelobordin.loan_calculator.api.LoanResponse;
import br.com.angelobordin.loan_calculator.domain.Loan;

public class LoanMapper {

    public static LoanResponse convertResponse(Loan loan) {
        return new LoanResponse(loan.data_emprestimo(), loan.moeda(), loan.valor_obtido(), loan.data_vencimento());
    }
}
