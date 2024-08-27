package com.loan_calculator.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loan_calculator.api.domain.loan.Loan;
import com.loan_calculator.api.domain.loan.LoanRequestDTO;
import com.loan_calculator.api.domain.loan.LoanResponseDTO;
import com.loan_calculator.api.service.LoanService;

@RestController
@RequestMapping("/api/loan")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping
    public ResponseEntity<Loan> create(@RequestBody LoanRequestDTO body) {
        Loan newLoan = this.loanService.create(body);
        return ResponseEntity.ok(newLoan);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<LoanResponseDTO> getLoanById(@PathVariable Long id) {
        LoanResponseDTO loan = this.loanService.getLoanById(id);
        return ResponseEntity.ok(loan);
    }
    
    @GetMapping
    public ResponseEntity<List<LoanResponseDTO>> getLoanList() {
        List<LoanResponseDTO> loans = this.loanService.getLoanList();
        return ResponseEntity.ok(loans);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Loan> updateLoanById(@PathVariable Long id, @RequestBody LoanRequestDTO loanDetails) {
        Loan loan = this.loanService.updateLoanById(id, loanDetails);
        return ResponseEntity.ok(loan);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLoanById(@PathVariable Long id) {
        return ResponseEntity.ok(this.loanService.deleteLoanById(id));
    }
}
