package com.example.chapter5.handler

import com.example.chapter5.model.Customer
import com.example.chapter5.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.ServerResponse.status
import reactor.core.publisher.Mono

@Component
class CustomerHandler(val customerService: CustomerService) {
    fun get(request: ServerRequest): Mono<ServerResponse> {
        return customerService.getCustomer(request.pathVariable("id").toInt())
            .flatMap { ok().body(it, Customer::class.java) }
            .switchIfEmpty(status(HttpStatus.NOT_FOUND).build())
    }

}