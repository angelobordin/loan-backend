package br.com.angelobordin.loan_calculator.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.angelobordin.loan_calculator.api.LoanRequest;
import br.com.angelobordin.loan_calculator.api.LoanResponse;
import br.com.angelobordin.loan_calculator.domain.LoanService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping
    public ResponseEntity<Mono<LoanResponse>> create(@RequestBody LoanRequest request) {
        var loanResponse = loanService.create(request).map(LoanMapper::convertResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(loanResponse);
    }
}
