package com.example.chapter5.router

import com.example.chapter5.handler.CustomerHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.router

@Component
class CustomerRouter {

    @Autowired
    lateinit var customerHandler: CustomerHandler

    @Bean
    fun customerRoutes(): RouterFunction<*> = router {
        "customer".nest {
            GET(customerHandler::search)
            GET("/{id}", customerHandler::get)
            POST(customerHandler::create)
            DELETE("/{id}", customerHandler::remove)
        }
    }
}