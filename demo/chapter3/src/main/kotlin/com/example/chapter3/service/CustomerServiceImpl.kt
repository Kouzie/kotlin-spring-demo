package com.example.kotlin.demo.chapter3.service

import com.example.kotlin.demo.chapter3.model.Customer
import org.springframework.stereotype.Component

@Component
class CustomerServiceImpl: CustomerService {
    companion object {
        val initialCustomers = arrayOf(
            Customer(1, "Kotlin", Customer.Telephone("+82", "010-1234-1111")),
            Customer(2, "Spring"),
            Customer(3, "Microservice"),
        )
    }

    val customers = HashMap<Int, Customer>(initialCustomers.associateBy { it.id })

    override fun getCustomer(id: Int): Customer? {
        return customers[id]
    }

    override fun createCustomer(customer: Customer) {
        customers[customer.id] = customer;
    }

    override fun deleteCustomer(id: Int) {
        customers.remove(id)
    }

    override fun updateCustomer(id: Int, customer: Customer) {
        deleteCustomer(id)
        createCustomer(customer)
    }

    override fun searchCustomer(nameFilter: String): List<Customer> {
        return customers
            .filter { it.value.name.contains(nameFilter, true) }
            .map { it.value }
            .toList();
    }
}