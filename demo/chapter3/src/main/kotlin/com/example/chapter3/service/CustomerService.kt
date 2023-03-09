package com.example.kotlin.demo.chapter3.service

import com.example.kotlin.demo.chapter3.model.Customer
import org.springframework.stereotype.Service

@Service
interface CustomerService {
    fun getCustomer(id: Int): Customer?
    fun createCustomer(customer:Customer)
    fun deleteCustomer(id:Int)
    fun updateCustomer(id:Int, customer:Customer)
    fun searchCustomer(nameFilter:String): List<Customer>
}