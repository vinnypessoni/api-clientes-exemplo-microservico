package com.viniciuspessoni.domain

class Cliente (var nome: String, var idade: Int, var id: Int, var risco: Int = 0){

    fun calcularRisco(): Int{
        risco = 110 - idade * 5
        return risco
    }

    override fun toString(): String{
        return "{ NOME: $nome, IDADE: $idade, ID: $id }"
    }
}