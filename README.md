## API Exemplo Cliente

Essa é um exemplo de uma API (microserviço) para estudo tanto de programação quanto testes automatizados.

Ela foi criada para o curso de teste de APIS com Postman, Java, Restassured [disponível aqui](https://viniciuspessoni.com/curso-testando-apis-com-postman-do-zero)

Mesmo sem ter feito o curso, você pode baixar e executar a API pra estudo =)

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


Caso não queira usar o IntelliJ para executar o projeto, você pode fazer isso a partir do terminal.
Abra um terminal, navegue até a pasta raiz do projeto e execute os comandos para Linux ou MacOs:


    ./gradlew clean build
    ./gradlew bootRun

No Windows devemos executar os mesmos comandos, mas sem o ./ antes.

     gradlew clean build
     gradlew bootRun


O primeiro comando irá construir a aplicação e o segundo irá rodar ela no terminal em que você está e será possivel ver os logs das API.           

Caso não queira clonar e rodar a API do seu próprio computador, você pode usar a versão que está rodando no HEROKU por aqui https://tester-global-cliente-api.herokuapp.com/

### A API

A API possui os endpoints:

    / ou /clientes --> GET clientes: para pegar todos os clientes.
    /cliente/{ID}  --> GET cliente por ID: para pegar um cliente com base no seu id.
    /cliente       --> POST cliente para cadastrar um cliente novo.
    /cliente       --> PUT atualiza cliente já cadastrado previamente.
    /cliente/{ID}  --> DELETE cliente por ID para deletar um cliente por ID.
    /risco/{id}    --> GET cliente por ID com o risco (Basic Authentication)

        ** OBS: o endpoint RISCO é autenticado com o tipo de autenticação básica (usuário e senha)

Exemplo:

    http://localhost:8080/
        OU
    http://localhost:8080/clientes
    deve te mostrar a lista de clientes cadastrados

Para cadastrar um cliente, vá no POSTMAN e crie um método POST.           
O corpo do método POST é um JSON e deve conter:

            {
                "nome": "Vinny",
                "idade": 30,
                 "id": "123456789"
            }

Para uma visão completa dos códigos de resposta em cada endpoint, enquanto o seviço estiver sendo executado, veja o SWAGGER no endereço: http://localhost:8080/swagger-ui.html    

O swagger dela também está disponível no HEROKU pelo link:
https://tester-global-cliente-api.herokuapp.com/swagger-ui.html#/

Baixe a coleção do POSTMAN que possui os requests (métodos HTTP)  que exercitam essa API a partir do meu site:

[viniciuspessoni.com/downloads]( https://www.viniciuspessoni.com/downloads)

Me Segue =}

😍 [YouTube]( https://www.youtube.com/c/pessonizando)

💗 [Instagram](https://www.instagram.com/pessonizando)

⭐ [Telegram](https://t.me/pessonizando)
