- [Gerenciador](#Gerenciador)
    - [Introdução](#introdução)
    - [API endpoints](#api-endpoints)
        - [GET /api/usuarios/]
        - [GET /api/usuarios/{id}]
        - [GET /api/usuarios/cpf/{cpf}]
        - [GET /api/usuarios/nome/{nome}]
        - [GET /api/usuarios/status/{idStatus}]
        - [GET /api/usuarios/cargo/{idCargo}]
        - [GET /api/usuarios/perfil/{idPerfil}]
        - [POST /api/usuarios/]
        - [DELETE /usuarios/{id}]
        
        
        
    - [Executando a app](#executando-a-app)

<!-- /TOC -->

## Introdução

Gerenciador é uma API REST feita para armazenar e manipular uma coleção de usuários.  

Escrita em Java com framework SPRING-BOOT e usando base de dados H2 (banco em memória).  



## Executando a app  


Uma vez que o código da aplicação disponível em uma pasta local, entrar no diretório onde está o pom.xml e rodar os seguintes comandos:

**compilar a app:** `mvn compile`  
**rodar a aplicação:** `mvn spring-boot:run`

