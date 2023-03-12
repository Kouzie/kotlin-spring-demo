package com.example.chapter5.service

import com.example.chapter5.model.Customer
import com.example.chapter5.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class CustomerServiceImpl : CustomerService {
    @Autowired
    lateinit var customerRepository: CustomerRepository

    override fun getCustomer(id: Int): Mono<Customer> {
        return customerRepository.findById(id)
    }

    override fun removeCustomer(id: Int): Mono<Boolean> {
        return customerRepository.deleteById(id)
            .map { result -> result.deletedCount > 0 }
    }

    override fun searchCustomer(nameFilter: String): Flux<Customer> {
        return customerRepository.findCustomer(nameFilter)
    }

    override fun createCustomer(customer: Mono<Customer>): Mono<Customer> {
        return customerRepository.create(customer)
    }


}