package domain

import com.viniciuspessoni.domain.Cliente
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName

/**
 * Testes unitários para a classe de domínio Cliente
 */
class ClienteTeste {

    @Test
    @DisplayName ("Quando criar o cliente James bond, Então seu risco deve ser calculado corretamente ")
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