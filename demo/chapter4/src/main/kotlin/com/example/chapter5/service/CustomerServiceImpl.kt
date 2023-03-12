package com.example.chapter5.service

import com.example.chapter5.model.Customer
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toFlux
import reactor.kotlin.core.publisher.toMono

@Component
class CustomerServiceImpl : CustomerService {
    companion object {
        val customers = arrayOf(
            Customer(1, "Kotlin", Customer.Telephone("+82", "010-1234-1111")),
            Customer(2, "Spring"),
            Customer(3, "Microservice"),
        )
    }

    override fun getCustomer(id: Int): Mono<Customer> {
        return customers.getOrNull(id)?.toMono() ?: Mono.empty()
    }

//    override fun createCustomer(customer: Customer) {
//        customers[customer.id] = customer;
//    }
//
//    override fun deleteCustomer(id: Int) {
//        customers.remove(id)
//    }
//
//    override fun updateCustomer(id: Int, customer: Customer) {
//        deleteCustomer(id)
//        createCustomer(customer)
//    }

    override fun searchCustomer(nameFilter: String): Flux<Customer> {
        return customers
            .filter { it.name.contains(nameFilter, true) }
            .toList().toFlux();
    }

    override fun createCustomer(customerMono: Mono<Customer>): Mono<*> {
        return customerMono.map {
            customers[it.id] = it
            it
        }.toMono()
    }
}