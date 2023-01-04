package com.helios.customer;

import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository customerRepository) {
    public void registerCustomer(CustomerRegistrationRequest request) {
       Customer customer = Customer.builder()
               .firstName(request.firstName())
               .lastName(request.lastName())
               .customerEmail(request.email())
               .build();
       // todo : check if the email is valid
        // todo: check if the email is not taken

        //store customer in the db
        customerRepository.save(customer);
    }
}
