package com.viniciuspessoni.domain

class Cliente (var nome: String, var idade: Int, var id: Int){

    fun calcularRisco(): Int{
        return 100 - idade * 5
    }

    override fun toString(): String{
        return "{ NOME: $nome, IDADE: $idade, ID: $id }"
    }
}