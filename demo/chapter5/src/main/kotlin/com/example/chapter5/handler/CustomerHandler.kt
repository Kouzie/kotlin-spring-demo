package com.example.chapter5.handler

import com.example.chapter5.model.Customer
import com.example.chapter5.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters.fromValue
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.*
import org.springframework.web.reactive.function.server.bodyToMono
import reactor.core.publisher.Mono
import java.net.URI

@Component
class CustomerHandler(val customerService: CustomerService) {
    fun get(request: ServerRequest): Mono<ServerResponse> {
        return customerService.getCustomer(request.pathVariable("id").toInt())
            .flatMap { ok().body(fromValue(it)) }
            .switchIfEmpty(status(HttpStatus.NOT_FOUND).build())
    }

    fun create(request: ServerRequest): Mono<ServerResponse> {
        return customerService.createCustomer(request.bodyToMono())
            .flatMap { created(URI.create("/customer/${it.id}")).build() } // response header(location) 에 문자열 삽입
    }

    fun remove(request: ServerRequest): Mono<ServerResponse> {
        return customerService.removeCustomer(request.pathVariable("id").toInt())
            .flatMap { if (it) ok().build() else status(HttpStatus.NOT_FOUND).build() }
    }

    fun search(request: ServerRequest): Mono<ServerResponse> {
        return ok().body(customerService.searchCustomer(request.queryParam("nameFilter").orElse("")), Customer::class.java)
    }

}