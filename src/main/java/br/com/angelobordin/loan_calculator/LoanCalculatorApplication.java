package br.com.angelobordin.loan_calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("br.com.angelobordin.loan_calculator")
@EnableJpaRepositories(basePackages = "br.com.angelobordin.loan_calculator")
public class LoanCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanCalculatorApplication.class, args);
	}

}
