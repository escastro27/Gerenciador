- [Gerenciador](#Gerenciador)
    - [Introdução](#introdução)
    - [API endpoints](#api-endpoints)
        Usuario:
        - [GET /api/v1/usuarios]
        - [GET /api/v1/usuarios/{id}]
        - [GET /api/v1/usuarios/cpf/{cpf}]
        - [GET /api/v1/usuarios/nome/{nome}]
        - [GET /api/v1/usuarios/status/{idStatus}]
        - [GET /api/v1/usuarios/cargo/{idCargo}]
        - [GET /api/v1/usuarios/perfil/{idPerfil}]
        - [GET /api/v1/usuarios/busca1]
        - [GET /api/v1/usuarios/busca2]
        - [PUT /api/v1/usuarios]
        - [POST /api/v1/usuarios/]
        - [DELETE /usuarios/{id}]
        
        
        Perfil:
         - [GET /api/v1/perfis]
         - [GET /api/v1/perfis/{id}]
         - [POST /api/v1/perfis/]
         - [DELETE /perfil/{id}]
         
         
         Cargo:
         - [GET /api/v1/cargos]
         - [GET /api/v1/cargos/{id}]
         - [POST /api/v1/cargos/]
         - [DELETE /cargo/{id}] 
         
         
         Status:
         - [GET /api/v1/status]
         - [GET /api/v1/status/{id}]
         - [POST /api/v1/status/]
         - [DELETE /status/{id}] 
        
        
        
    - [Executando a app](#executando-a-app)

<!-- /TOC -->

## Introdução

Gerenciador é uma API REST feita para armazenar e manipular uma coleção de usuários.  

Escrita em Java com framework SPRING-BOOT e usando base de dados H2 (banco em memória).  

O JSON abaixo exemplifica um usuário:
```
{
        "id": 2,
        "nome": "Maria Santos",
        "cpf": "04612723007",
        "sexo": "F",
        "dataNascimento": "01/01/1970",
        "cargo": "Administrador",
        "perfil": "Comum",
        "status": "ATIVO"
    }
```


## API endpoints

### GET /api/v1/usuarios
**Descrição:** retorna todos os usuários cadastrados.  


### GET /api/v1/usuarios/{id}
**Descrição:** retorna o usuário cadastrado com o id informado.  

### GET /api/v1/usuarios/cpf/{cpf}
**Descrição:** retorna o usuário cadastrado com o cpf informado. 

### GET /api/v1/usuarios/nome/{nome}
**Descrição:** retorna o usuário cadastrado com o nome informado. 


### GET /api/v1/usuarios/status/{idStatus}
**Descrição:** retorna todos o usuários cadastrados com o id do status informado. 

### GET /api/v1/usuarios/cargo/{idCargo}
**Descrição:** retorna todos o usuários cadastrados com o id do cargo informado. 

### GET /api/v1/usuarios/perfil/{idPerfil}
**Descrição:** retorna todos o usuários cadastrados com o id do perfil informado. 

### GET /api/v1/usuarios/busca1
**Descrição:** retorna todos o usuários cadastrados com o cpf iniciado por Zero. 

### GET /api/v1/usuarios/busca2
**Descrição:** retorna todos o usuários cadastrados do sexo feminino maiores de 18 anos. 

### PUT /api/v1/usuarios
**Descrição:** Altera um usuário. 

### POST /api/v1/usuarios/
**Descrição:** Cria um usuário. 


### DELETE /usuarios/{id}
**Descrição:** Exclui um usuário com o id informado. 




### GET /api/v1/perfis
**Descrição:** retorna todos os perfis cadastrados.  

### GET /api/v1/perfis/{id}
**Descrição:** retorna o perfil com o id informado. 

### POST /api/v1/perfis/
**Descrição:** cria um perfil. 
```
 {
        "descricao": "Administrador"
    }
```


### DELETE /perfil/{id}
**Descrição:** Exclui o perfil com o id informado. 




### GET /api/v1/cargos
**Descrição:** retorna todos os cargos cadastrados.  

### GET /api/v1/cargos/{id}
**Descrição:** retorna o cargo com o id informado. 

### POST /api/v1/cargos/
**Descrição:** cria um cargo. 
```
 {
        "descricao": "Gerente"
    }
```

### DELETE /cargo/{id}
**Descrição:** Exclui o cargo com o id informado. 



### GET /api/v1/status
**Descrição:** retorna todos os status cadastrados.  

### GET /api/v1/status/{id}
**Descrição:** retorna o status com o id informado. 

### POST /api/v1/status/
**Descrição:** cria um status. 
```
 {
        "descricao": "Pendente"
    }
```

### DELETE /status/{id}
**Descrição:** Exclui o status com o id informado. 



## Executando a app  


Uma vez que o código da aplicação disponível em uma pasta local, entrar no diretório onde está o pom.xml e rodar os seguintes comandos:

**compilar a app:** `mvn compile`  
**rodar a aplicação:** `mvn spring-boot:run`

