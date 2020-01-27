package com.viniciuspessoni.controller

import com.viniciuspessoni.domain.Cliente
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.validation.Valid

@RestController
class ClienteController(){

    var listaClientes: MutableList<Cliente> = LinkedList()

    @GetMapping("clientes", "/")
    fun getTodosClientes(): MutableList<Cliente>{
        return listaClientes
    }

    @PostMapping (path = ["/cliente"], consumes = ["application/json"])
    fun cadastraCliente(@RequestBody @Valid cliente: Cliente) {
        listaClientes.add(cliente)
        System.out.println("CLIENTE ADD: $cliente")
    }
}