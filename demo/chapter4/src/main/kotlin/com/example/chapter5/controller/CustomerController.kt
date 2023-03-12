package com.example.chapter5.controller

import com.example.chapter5.model.Customer
import com.example.chapter5.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono


@RestController
@RequestMapping("/customer")
class CustomerController {

    @Autowired
    private lateinit var customerService: CustomerService

    @GetMapping
    fun getCustomers(@RequestParam(required = false) nameFilter: String) = customerService.searchCustomer(nameFilter)

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: Int) = customerService.getCustomer(id)

    @PostMapping
    fun createCustomer(@RequestBody customerMono: Mono<Customer>) = customerService.createCustomer(customerMono)
}