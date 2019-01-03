package com.bookappkotlin.bookappkotlin

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BookappkotlinApplication

fun main (args: Array<String>){
	SpringApplication.run(BookappkotlinApplication::class.java, *args)
}

