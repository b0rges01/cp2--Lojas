# API Lojas - Checkpoint 2

API RESTful de gerenciamento de **Lojas** e **Produtos**, desenvolvida com Spring Boot, Spring Data JPA e MySQL.

## Tecnologias utilizadas

- Java 17
- Spring Boot 3.4.5
- Spring Data JPA
- MySQL 8.0
- Lombok
- Springdoc OpenAPI (Swagger UI)
- Docker

---

## Pré-requisitos

- Java 17+
- Maven 3.8+
- Docker e Docker Compose instalados

---

## Como rodar a aplicação

### 1. Subir o banco de dados com Docker

Na raiz do projeto, execute:

```bash
docker-compose up -d
```

Isso irá:
- Criar um container MySQL 8.0 chamado `api_lojas_mysql`
- Criar automaticamente o banco de dados `api_lojas_db`
- Expor a porta `3306`

Para verificar se o container está rodando:

```bash
docker ps
```

Para parar o container:

```bash
docker-compose down
```

### 2. Rodar a aplicação

```bash
mvn spring-boot:run
```

A aplicação estará disponível em: **http://localhost:8080**

---

## Documentação da API (Swagger UI)

Acesse a documentação interativa em:

**http://localhost:8080**

---

## Endpoints disponíveis

### Lojas (`/lojas`)

| Método | Rota          | Descrição                  |
|--------|---------------|----------------------------|
| GET    | /lojas        | Retorna todas as lojas     |
| GET    | /lojas/{id}   | Retorna uma loja por ID    |
| POST   | /lojas        | Cria uma nova loja         |
| PUT    | /lojas/{id}   | Atualiza uma loja          |
| DELETE | /lojas/{id}   | Remove uma loja            |

### Produtos (`/produtos`)

| Método | Rota            | Descrição                    |
|--------|-----------------|------------------------------|
| GET    | /produtos       | Retorna todos os produtos    |
| GET    | /produtos/{id}  | Retorna um produto por ID    |
| POST   | /produtos       | Cria um novo produto         |
| PUT    | /produtos/{id}  | Atualiza um produto          |
| DELETE | /produtos/{id}  | Remove um produto            |

---

## Exemplos de requisição

### Criar uma Loja (POST /lojas)

```json
{
  "nome": "Loja Centro",
  "cnpj": "12.345.678/0001-90",
  "telefone": "(11) 99999-0000",
  "endereco": "Rua das Flores, 100 - Centro, São Paulo/SP",
  "email": "centro@lojas.com",
  "ativa": true
}
```

### Criar um Produto (POST /produtos)

```json
{
  "nome": "Notebook Gamer",
  "descricao": "Notebook com RTX 4060, 16GB RAM, SSD 512GB",
  "preco": 4999.90,
  "quantidadeEstoque": 10,
  "categoria": "Informática",
  "ativo": true
}
```

---

## Configurações do banco de dados

As configurações ficam em `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/api_lojas_db
spring.datasource.username=root
spring.datasource.password=root123
```

Se preferir, pode usar o comando `docker run` diretamente (alternativa ao docker-compose):

```bash
docker run -d \
  --name api_lojas_mysql \
  -e MYSQL_ROOT_PASSWORD=root123 \
  -e MYSQL_DATABASE=api_lojas_db \
  -p 3306:3306 \
  mysql:8.0
```
