package com.example.chapter5.model

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