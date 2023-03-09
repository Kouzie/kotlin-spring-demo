package com.example.chapter4.controller

import com.example.chapter4.model.Customer
import com.example.chapter4.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customer")
class CustomerController {

    @Autowired
    private lateinit var customerService: CustomerService

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: Int): Customer? {
        val customer = customerService.getCustomer(id)
        return customer;
    }

    @GetMapping("/customers")
    fun getCustomers(@RequestParam(required = false) nameFilter: String): List<Customer> {
        return customerService.searchCustomer(nameFilter)
    }
}