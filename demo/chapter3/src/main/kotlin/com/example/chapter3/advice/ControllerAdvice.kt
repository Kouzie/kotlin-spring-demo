package com.example.kotlin.demo.chapter3.advice

import com.example.kotlin.demo.chapter3.exception.CustomerNotFoundException
import com.example.kotlin.demo.chapter3.model.ErrorResponse
import com.fasterxml.jackson.core.JsonParseException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.servlet.http.HttpServletRequest

@ControllerAdvice
class ControllerAdvice {
    @ExceptionHandler(JsonParseException::class)
    fun jsonParseExceptionHandler(request: HttpServletRequest, exception: Exception): ResponseEntity<ErrorResponse> {
        return ResponseEntity(
            ErrorResponse("JSON Error", exception.message ?: "invalid json"),
            HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(CustomerNotFoundException::class)
    fun customerNotFoundExceptionHandler(request: HttpServletRequest, exception: Exception):ResponseEntity<ErrorResponse> {
        return ResponseEntity(
            ErrorResponse("Customer Not Found", exception.message!!),
            HttpStatus.NOT_FOUND)
    }
}