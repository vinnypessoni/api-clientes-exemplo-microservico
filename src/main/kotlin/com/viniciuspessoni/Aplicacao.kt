package com.viniciuspessoni

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class Aplicacao

fun main(args: Array<String>){
    SpringApplication.run(Aplicacao::class.java, *args)
}
