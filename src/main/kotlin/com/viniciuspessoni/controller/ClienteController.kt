package com.viniciuspessoni.controller

import com.viniciuspessoni.domain.Cliente
import org.springframework.http.HttpStatus.OK
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.status
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.RequestBody
import javax.validation.Valid
import kotlin.collections.HashMap

@RestController
class ClienteController(){

    var listaClientes: MutableMap<Int, Cliente> = HashMap()

    @GetMapping("clientes", "/")
    fun getTodosClientes(): Map<Int, Cliente>{
        return listaClientes
    }

    @GetMapping("cliente/{id}")
    fun getClientePorId(@PathVariable @Valid id: Int): String{
        if(listaClientes.containsKey(id))
            return listaClientes[id].toString()
        else
            return "Cliente não encontrado"
    }

    @PostMapping (path = ["/cliente"], consumes = ["application/json"])
    fun cadastraCliente(@RequestBody @Valid cliente: Cliente): ResponseEntity<MutableMap<Int, Cliente>> {
        listaClientes.put(cliente.id, cliente)
        System.out.println("CLIENTE ADD: $cliente")
        return status(CREATED).body(listaClientes)
    }

    @PutMapping (path = ["cliente"], consumes = ["application/json"])
    fun atualizaCliente(@RequestBody cliente: Cliente): ResponseEntity<Any> {
        if(listaClientes.containsKey(cliente.id)) {
            listaClientes.put(cliente.id, cliente)

            System.out.println("CLIENTE ATUALIZADO: $cliente")
            return status(OK).body(listaClientes)
        }
        else {
            System.out.println("CLIENTE NÃO ENCONTRADO: $cliente")
            return status(NOT_FOUND).body("Cliente não encontrado")
        }
    }

    @DeleteMapping("cliente/{id}")
    fun apagarCliente(@PathVariable @Valid id: Int): String {
        if(listaClientes.containsKey(id)) {
            var clienteParaRemover = listaClientes[id]
            System.out.println("CLIENTE REMOVIDO: $clienteParaRemover")
            listaClientes.remove(id)
            return "CLIENTE REMOVIDO: $clienteParaRemover"
        }
        else {
            System.out.println("CLIENTE NÃO ENCONTRADO: $id")
            return "Cliente não encontrado"
        }
    }

    @DeleteMapping("cliente/apagaTodos")
    fun apagarTodosClientes(): String {
        listaClientes.clear()
        System.out.println("TODOS CLIENTES REMOVIDOS")
        return listaClientes.toString()
    }
}