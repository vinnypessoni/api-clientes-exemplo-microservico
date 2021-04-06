package domain

import com.viniciuspessoni.domain.Cliente
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

/**
 * Testes unitários para a classe de domínio Cliente
 */
class ClienteTeste {

    @Test
    fun verficaCalculoDeRisco() {
        val clienteEsperado = Cliente(
            nome = "James Bond",
            idade = 35,
            id = 1007,
            risco = -65
        )
        val clienteObtido = Cliente(
            nome = "James Bond",
            idade = 35,
            id = 1007)
        assertThat(clienteEsperado.risco).isEqualTo(clienteObtido.calcularRisco())
    }
}