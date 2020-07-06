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
import kotlin.random.Random

@RestController
class ClienteController(){

    var listaClientes: MutableMap<Int, Cliente> = HashMap()

    @GetMapping("clientes", "/")
    fun getTodosClientes(): ResponseEntity<MutableMap<Int, Cliente>> {
        System.out.println("PEGA TODOS CLIENTES")
        return status(OK).body(listaClientes)
    }

    @GetMapping("cliente/{id}")
    fun getClientePorId(@PathVariable @Valid id: Int): ResponseEntity<Any> {
        if(listaClientes.containsKey(id)) {
            System.out.println("PEGA CLIENTE COM ID: " + listaClientes[id])
            return status(OK).body(listaClientes[id])
        }
        else {
            System.out.println("CLIENTE NÃO ENCONTRADO: $id")
            return status(NOT_FOUND).body("Cliente não encontrado")
        }
    }

    @GetMapping("risco/{id}")
    fun getRiscoPorId(@PathVariable @Valid id: Int): ResponseEntity<Any> {
        if(listaClientes.containsKey(id)) {
            val cliente = listaClientes[id]
            cliente!!.calcularRisco()
            System.out.println("PEGA RISCO DO CLIENTE PELO ID: $cliente")
            return status(OK).body(cliente)
        }
        else {
            System.out.println("CLIENTE NÃO ENCONTRADO: $id")
            return status(NOT_FOUND).body("Cliente não encontrado")
        }
    }

    @PostMapping (path = ["/cliente"], consumes = ["application/json"])
    fun cadastraCliente(@RequestBody @Valid cliente: Cliente): ResponseEntity<MutableMap<Int, Cliente>> {

        if(cliente.id == 0){
            cliente.id =  Random.nextInt(0, 9876543)
        }
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
    fun deletaCliente(@PathVariable @Valid id: Int): ResponseEntity<String> {
        if(listaClientes.containsKey(id)) {
            var clienteParaRemover = listaClientes[id]
            System.out.println("CLIENTE REMOVIDO: $clienteParaRemover")
            listaClientes.remove(id)
            return status(OK).body("CLIENTE REMOVIDO: $clienteParaRemover")
        }
        else {
            System.out.println("CLIENTE NÃO ENCONTRADO: $id")
            return status(NOT_FOUND).body("Cliente não encontrado")
        }
    }

    /**
     * Esse endpoint foi criado para ajudar a realizar os testes facilmente.
     * Com ele, podemos remover todos os clientes de uma vez.
     */
    @DeleteMapping("cliente/apagaTodos")
    fun deletaTodosClientes(): String {
        listaClientes.clear()
        System.out.println("TODOS CLIENTES REMOVIDOS")
        return listaClientes.toString()
    }
}