package com.example.kotlin.demo.chapter3.controller

import com.example.kotlin.demo.chapter3.exception.CustomerNotFoundException
import com.example.kotlin.demo.chapter3.model.ComplexObject
import com.example.kotlin.demo.chapter3.model.Customer
import com.example.kotlin.demo.chapter3.model.SimpleObject
import com.example.kotlin.demo.chapter3.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customer")
class CustomerController {

    @Autowired
    lateinit var customerService: CustomerService

    @GetMapping
    fun getCustomer(@RequestParam(required = false, defaultValue = "") nameFilter: String): List<Customer> {
        return customerService.searchCustomer(nameFilter)
    }

    @PostMapping
    fun createCustomer(@RequestBody customer: Customer) {
        customerService.createCustomer(customer)
    }

    @GetMapping("/{id}")
    fun getCustomerById(@PathVariable id: Int): Customer {
        return customerService.getCustomer(id) ?: throw CustomerNotFoundException("customer '$id' not found")
    }

    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable id: Int) {
        customerService.deleteCustomer(id)
    }

    @PatchMapping("/{id}")
    fun updateCustomer(@PathVariable id: Int, @RequestBody customer: Customer) {
        customerService.updateCustomer(id, customer)
    }

    @GetMapping("/hello")
    fun serializeTest()  = SimpleObject()

    @GetMapping("/complex")
    fun serializeComplexTest()  = ComplexObject(object1 = SimpleObject("more", "complex"))
}