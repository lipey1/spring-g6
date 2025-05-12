# Documentação do Projeto (Feito por Felipe)

## Visão Geral
Este é um projeto backend desenvolvido em Spring Boot que gerencia jogos, tipos de jogos e matérias. A aplicação segue o padrão de arquitetura REST e implementa operações CRUD (Create, Read, Update, Delete) para cada entidade do sistema.

## Estrutura do Projeto
O projeto segue uma arquitetura em camadas típica de aplicações Spring:

- **Controller**: Responsável por expor os endpoints REST da API
- **Service**: Contém a lógica de negócio da aplicação
- **Repository**: Lida com a persistência dos dados
- **DTO (Data Transfer Objects)**: Objetos utilizados para transferência de dados entre o cliente e o servidor

## Controladores

### JogoController (`/api/jogos`)
Gerencia operações relacionadas a jogos.

**Endpoints:**
- `GET /api/jogos` - Lista todos os jogos
- `GET /api/jogos/{id}` - Busca um jogo específico pelo ID
- `GET /api/jogos/tipo/{tipoJogoId}` - Lista jogos filtrados por tipo
- `POST /api/jogos` - Cria um novo jogo
- `PUT /api/jogos/{id}` - Atualiza um jogo existente
- `DELETE /api/jogos/{id}` - Remove um jogo

### MateriaController (`/api/materias`)
Gerencia operações relacionadas a matérias.

**Endpoints:**
- `GET /api/materias` - Lista todas as matérias
- `GET /api/materias/{id}` - Busca uma matéria específica pelo ID
- `POST /api/materias` - Cria uma nova matéria
- `PUT /api/materias/{id}` - Atualiza uma matéria existente
- `DELETE /api/materias/{id}` - Remove uma matéria

### TipoJogoController (`/api/tipos-jogo`)
Gerencia operações relacionadas a tipos de jogos.

**Endpoints:**
- `GET /api/tipos-jogo` - Lista todos os tipos de jogos
- `GET /api/tipos-jogo/{id}` - Busca um tipo de jogo específico pelo ID
- `POST /api/tipos-jogo` - Cria um novo tipo de jogo
- `PUT /api/tipos-jogo/{id}` - Atualiza um tipo de jogo existente
- `DELETE /api/tipos-jogo/{id}` - Remove um tipo de jogo

## Como Fazer Requisições

### Exemplo de Requisição POST
Para criar um novo recurso, você deve enviar uma requisição POST com o corpo em formato JSON:

```
POST http://localhost:8080/api/jogos
Content-Type: application/json

{
  "nome": "Nome do Jogo",
  "descricao": "Descrição do jogo",
  "tipoJogoId": 1
}
```

### Exemplo de Requisição PUT
Para atualizar um recurso existente:

```
PUT http://localhost:8080/api/jogos/1
Content-Type: application/json

{
  "nome": "Nome Atualizado",
  "descricao": "Descrição atualizada",
  "tipoJogoId": 2
}
```

### Exemplo de Requisição GET
Para obter recursos:

```
GET http://localhost:8080/api/jogos
GET http://localhost:8080/api/jogos/1
GET http://localhost:8080/api/jogos/tipo/2
```

### Exemplo de Requisição DELETE
Para remover um recurso:

```
DELETE http://localhost:8080/api/jogos/1
```

## Validação
A aplicação utiliza validação de dados com a anotação `@Valid` nos controllers, garantindo que os dados recebidos estejam de acordo com as regras de negócio definidas.

## Relacionamentos
Com base na estrutura da API, podemos inferir que existe uma relação entre Jogos e Tipos de Jogos, onde um Tipo de Jogo pode estar associado a vários Jogos.
