package br.com.angelobordin.loan_calculator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.angelobordin.loan_calculator.domain.LoanRepository;
import br.com.angelobordin.loan_calculator.domain.LoanService;

@Configuration
public class LoanConfig {

    @Bean
    LoanService loanService(LoanRepository loanRepository) {
        return new LoanService(loanRepository);
    }
}
