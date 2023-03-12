package com.example.chapter5.component

import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.ReactiveMongoTemplate


@Configuration
class MongoConfig {

    @Bean(name = ["reactiveMongoTemplate"])
    fun reactiveMongoOperations(): ReactiveMongoTemplate {
        val client: MongoClient = MongoClients.create("mongodb://mongoadmin:secret@localhost:27017")
        return ReactiveMongoTemplate(client, "microservice")
    }
}