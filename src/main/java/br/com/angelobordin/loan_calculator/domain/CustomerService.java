package br.com.angelobordin.loan_calculator.domain;

import java.time.LocalDateTime;

import br.com.angelobordin.loan_calculator.api.CustomerRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Mono<Customer> create(CustomerRequest customerRequest) {
        return customerRepository.save(
            new Customer(null, customerRequest.name(), customerRequest.cpf(), null, null)
        );
    }
    
    public Mono<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public Flux<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    
    public Mono<Customer> updateCustomerById(Long id, CustomerRequest customerDetails) {
        return customerRepository.findById(id)
                .flatMap(existingCustomer -> {
                    Customer updatedCustomer = new Customer(
                            existingCustomer.id(),
                            customerDetails.cpf() != null ? customerDetails.cpf() : existingCustomer.cpf(),
                            customerDetails.name() != null ? customerDetails.name() : existingCustomer.name(),
                            existingCustomer.createdAt(),
                            LocalDateTime.now()
                    );
                    System.out.println("UpdatedCustomer" + updatedCustomer);
                    return customerRepository.save(updatedCustomer);
                });
    }

    public Mono<Void> deleteCustomerById(Long id) {
        return customerRepository.deleteById(id);
    }
}
