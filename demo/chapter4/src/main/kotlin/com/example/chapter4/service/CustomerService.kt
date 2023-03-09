package com.example.chapter4.service

import com.example.chapter4.model.Customer

interface CustomerService {
    fun getCustomer(id: Int): Customer?
    fun searchCustomer(nameFilter: String): List<Customer>
}