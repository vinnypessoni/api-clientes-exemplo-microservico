## API Exemplo Cliente

Essa é um exemplo de uma API simples para estudo tanto de programação quanto testes automatizdos.

Usei Kotlin e Springboot para programar essa API.

### Requisitos

Baixe e instale o [INTELIJ](https://www.jetbrains.com/idea/)

Baixe e instale a JDK mais recente [JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)


### Como rodar esse projeto 

Clone ou baixe o projeto.

Navegue até a pasta com.viniciuspessoni e abra a classe Aplicacao.kt.

Um botão verde (um play) deve aparecer ao lado na linha 9, basta apertar ele. 

A aplicação será iniciada e um servidor estará rodando e acessivel no endereço:

        localhost:8080

### A API 

A API possui os métodos:
 
    GET clientes para pegar todos os clientes. 
    GET cliente por ID pegar todos os clientes. 
    POST cliente para cadastrar um cliente novo. 
    DELETE cliente por ID para deletar um cliente por ID. 
    
Exemplo:

    http://localhost:8080/
        OU
    http://localhost:8080/clientes
    deve te mostrar a lista de clientes cadastrados
    
Para cadastrar um cliente, vá no POSTMAN e crie um método POST.           
O corpo do método POST é um JSON e deve conter:
            
            { 
                nome: "Vinny",
                idade: 30, 
                id: "123456789" 
            }

É possível baixar a coleção do POSTMAN que possui os requests (métodos HTTP)  que exercitam essa API a partir do meu site:

[viniciuspessoni.com -> meu site com vários materias]( https://www.viniciuspessoni.com/downloads)

Também estou presente em:
[YouTube]( https://www.youtube.com/c/pessonizando)

[Instagram](https://www.instagram.com/pessonizando)

[Telegram](https://t.me/pessonizando)