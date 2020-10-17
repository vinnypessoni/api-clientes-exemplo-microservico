package domain

import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import org.hamcrest.Matchers
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpHeaders
import org.springframework.test.context.junit.jupiter.SpringExtension


@ExtendWith(SpringExtension::class)

@SpringBootTest(
    classes = [com.viniciuspessoni.Aplicacao::class],
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)

class IntegracaoTeste {

    @LocalServerPort
    private val port = 0
    var restTemplate = TestRestTemplate()
    var headers: HttpHeaders = HttpHeaders()

    @Test
    @Throws(Exception::class)
    @DisplayName("Quando eu cadastrar um cliente, Então ele deve ser salvo com sucesso")
    fun quandoCriarCliente_EntãoEleDeveSerCriadoComSucesso() {

        val corpoRequisicao = "{\n" +
                "  \"nome\": \"Vinny\",\n" +
                "  \"idade\": \"30\",\n" +
                "  \"id\": \"1234\"\n" +
                "}"

        val respostaEsperada = "{\"1234\":" +
                "{\"nome\":\"Vinny\"," +
                "\"idade\":30," +
                "\"id\":1234," +
                "\"risco\":0}" +
                "}"

        given()
            .contentType(ContentType.JSON)
            .body(corpoRequisicao)
            .`when`().post(criaUrlComPorta("/cliente"))
            .then()
            .statusCode(201)
            .assertThat().body(Matchers.containsString(respostaEsperada))
    }

    private fun criaUrlComPorta(uri: String): String {
        return "http://localhost:$port$uri"
    }
}