package com.example.kotlin.demo.chapter3.model

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
class Customer(
    val id: Int = 0,
    val name: String = "",
    val telephone: Telephone? = null
) {
    data class Telephone(
        var countryCode: String = "",
        var telephoneNumber: String = ""
    )
}
