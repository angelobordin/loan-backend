package com.loan_calculator.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loan_calculator.api.domain.customer.Customer;
import com.loan_calculator.api.domain.customer.CustomerRequestDTO;
import com.loan_calculator.api.domain.customer.CustomerResponseDTO;
import com.loan_calculator.api.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody CustomerRequestDTO body) {
        Customer newCustomer = this.customerService.create(body);
        return ResponseEntity.ok(newCustomer);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<CustomerResponseDTO> getCustomerById(@PathVariable Long id) {
        CustomerResponseDTO customer = this.customerService.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponseDTO>> getCustomerList() {
        List<CustomerResponseDTO> customers = this.customerService.getCustomerList();
        return ResponseEntity.ok(customers);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Customer> updateCustomerById(@PathVariable Long id, @RequestBody CustomerRequestDTO loanDetails) {
        Customer customer = this.customerService.updateCustomerById(id, loanDetails);
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(this.customerService.deleteCustomerById(id));
    }
}
