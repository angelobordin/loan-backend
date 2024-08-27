package com.loan_calculator.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loan_calculator.api.domain.customer.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
