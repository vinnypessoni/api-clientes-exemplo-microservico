package com.viniciuspessoni.controller

import com.viniciuspessoni.domain.Cliente
import org.springframework.web.bind.annotation.*
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
    fun cadastraCliente(@RequestBody @Valid cliente: Cliente): MutableMap<Int, Cliente>{
        listaClientes.put(cliente.id, cliente)
        System.out.println("CLIENTE ADD: $cliente")
        return listaClientes
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
            return "Cliente não encontrado"
        }
    }
}