package com.example.chapter5.service

import com.example.chapter5.model.Customer
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface CustomerService {
    fun getCustomer(id: Int): Mono<Customer>
    fun removeCustomer(id: Int): Mono<Boolean>
    fun searchCustomer(nameFilter: String): Flux<Customer>
    fun createCustomer(customerMono: Mono<Customer>): Mono<Customer>
}