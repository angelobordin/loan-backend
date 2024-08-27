package br.com.angelobordin.loan_calculator.web;

import br.com.angelobordin.loan_calculator.api.CustomerResponse;
import br.com.angelobordin.loan_calculator.domain.Customer;
import reactor.core.publisher.Flux;

public class CustomerMapper {
    
    public static CustomerResponse convertResponse(Customer customer) {
        return new CustomerResponse(customer.cpf(), customer.name(), customer.createdAt(), customer.updatedAt());
    }

    public static Flux<CustomerResponse> convertResponseFlux(Flux<Customer> customers) {
        return customers.map(CustomerMapper::convertResponse);
    }

}