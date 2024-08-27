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

import br.com.angelobordin.loan_calculator.api.CustomerResponse;
import br.com.angelobordin.loan_calculator.api.CustomerRequest;
import br.com.angelobordin.loan_calculator.domain.CustomerService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Mono<CustomerResponse>> create(@RequestBody CustomerRequest request) {
        var response = customerService.create(request).map(CustomerMapper::convertResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<CustomerResponse>> getCustomerById(@PathVariable Long id) {
        var response = customerService.getCustomerById(id).map(CustomerMapper::convertResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public Flux<CustomerResponse> getAllCustomers() {
        return customerService.getAllCustomers().transform(CustomerMapper::convertResponseFlux);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Mono<CustomerResponse>> updateCustomerById(@PathVariable Long id, @RequestBody CustomerRequest customerDetails) {
        var response = customerService.updateCustomerById(id, customerDetails).map(CustomerMapper::convertResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Object>> deleteCustomerById(@PathVariable Long id) {
        return customerService.deleteCustomerById(id)
                .then(Mono.just(ResponseEntity.noContent().build()))
                .onErrorResume(e -> Mono.just(ResponseEntity.notFound().build()));
    }
}
