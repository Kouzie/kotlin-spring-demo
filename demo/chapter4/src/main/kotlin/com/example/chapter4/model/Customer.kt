package com.example.chapter4.model

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