##### API Exemplo Cliente

Essa é um exemplo de uma API simples para estudo tanto de programação quanto testes automatizdos.


### Como rodar esse projeto 

Após clonar o projeto do GIT, sugiro abri-lo no INTELIJ [https://www.jetbrains.com/idea/]

Navegue até a pasta com.viniciuspessoni e abra a classe Aplicacao.kt.

Um botão verde (um play) deve aparecer ao lado na linha 9, basta apertar ele. 

A aplicação será iniciada e um servidor estará rodando e acessivel no endereço:

        localhost:8080

### A API 

A API possui os métodos:
 
    GET para pegar todos os clientes. 
    POST para cadastrar um cliente novo. 
    
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
                id: "esse é um id" 
            }

É possível baixar a coleção do POSTMAN que possui esses dois métodos do meu site:
    https://www.viniciuspessoni.com/downloads
    https://www.youtube.com/c/pessonizando
    https://www.instagram.com/pessonizando/