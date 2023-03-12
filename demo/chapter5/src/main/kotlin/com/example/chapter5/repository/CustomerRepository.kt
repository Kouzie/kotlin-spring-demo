package com.example.chapter5.repository

import com.example.chapter5.model.Customer
import com.mongodb.client.result.DeleteResult
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.findById
import org.springframework.data.mongodb.core.query.Criteria.where
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.isEqualTo
import org.springframework.data.mongodb.core.remove
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono
import javax.annotation.PostConstruct

//interface CustomerRepository : ReactiveCrudRepository<Customer, Int> {
//}

@Repository
class CustomerRepository(private val template: ReactiveMongoTemplate) {
    companion object {
        val customers = listOf(
            Customer(1, "Kotlin", Customer.Telephone("+82", "010-1234-1111")),
            Customer(2, "Spring"),
            Customer(3, "Microservice"),
        )
    }

    @PostConstruct
    fun initData() {
        customers.map(Customer::toMono)
            .map(this::create)
            .map(Mono<Customer>::subscribe)
    }

    fun create(customer: Mono<Customer>): Mono<Customer> {
        return template.save(customer);
    }

    fun findById(id: Int): Mono<Customer> {
        return template.findById(id)
    }

    fun deleteById(id: Int): Mono<DeleteResult> {
        return template.remove<Customer>(Query(where("_id").isEqualTo(id)))
    }

    fun findCustomer(nameFilter: String): Flux<Customer> {
        return template.find(Query(where("name").regex(".*$nameFilter.*", "i")), Customer::class.java)
    }
}