package br.com.angelobordin.loan_calculator.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.angelobordin.loan_calculator.api.LoanRequest;
import br.com.angelobordin.loan_calculator.api.LoanResponse;
import br.com.angelobordin.loan_calculator.domain.LoanService;
import reactor.core.publisher.Flux;
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

    @GetMapping("/{id}")
    public ResponseEntity<Mono<LoanResponse>> getLoanById(@PathVariable Long id) {
        var loanResponse = loanService.getLoanById(id).map(LoanMapper::convertResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(loanResponse);
    }

    @GetMapping
    public Flux<LoanResponse> getAllLoans() {
        return loanService.getAllLoans().transform(LoanMapper::convertResponseFlux);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Mono<LoanResponse>> updateLoanById(@PathVariable Long id, @RequestBody LoanRequest loanDetails) {
        var response = loanService.updateLoanById(id, loanDetails).map(LoanMapper::convertResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Object>> deleteLoanById(@PathVariable Long id) {
        return loanService.deleteLoanById(id)
                .then(Mono.just(ResponseEntity.noContent().build()))
                .onErrorResume(e -> Mono.just(ResponseEntity.notFound().build()));
    }
}
