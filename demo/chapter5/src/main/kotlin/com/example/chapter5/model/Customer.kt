package com.example.chapter5.model

import org.springframework.data.mongodb.core.mapping.Document


@Document(value = "Customers")
class Customer(
    val id: Int = 0,
    val name: String = "",
    val telephone: Telephone? = null
) {
    data class Telephone(
        val countryCode: String = "",
        val telephoneNumber: String = ""
    )
}