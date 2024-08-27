package com.loan_calculator.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan_calculator.api.domain.customer.Customer;
import com.loan_calculator.api.domain.customer.CustomerResponseDTO;
import com.loan_calculator.api.domain.loan.Loan;
import com.loan_calculator.api.domain.loan.LoanRequestDTO;
import com.loan_calculator.api.domain.loan.LoanResponseDTO;
import com.loan_calculator.api.repositories.CustomerRepository;
import com.loan_calculator.api.repositories.LoanRepository;

@Service
public class LoanService {

    
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private LoanRepository repository;

    public Loan create(LoanRequestDTO data) {
        Customer customer = this.customerRepository.findById(data.customer_id()).orElseThrow(() -> new IllegalArgumentException("Customer not found")); 

        Loan newLoan = new Loan();
        newLoan.setCustomer(customer);
        newLoan.setDataEmprestimo(data.dataEmprestimo());
        newLoan.setMoeda(data.moeda());
        newLoan.setValorObtido(data.valorObtido());
        newLoan.setDataVencimento(data.dataVencimento());

        this.repository.save(newLoan);

        return newLoan;
    }

    public List<LoanResponseDTO> getLoanList() {
        List<Loan> loans = this.repository.findAll();
        return loans.stream().map((Loan l) -> new LoanResponseDTO(l.getId(), l.getDataEmprestimo(), l.getMoeda(), l.getValorObtido(), l.getDataVencimento(), l.getCustomer())).collect(Collectors.toList());
    }
}
