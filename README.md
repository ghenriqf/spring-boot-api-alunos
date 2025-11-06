## API REST de Gerenciamento de Alunos com Spring Boot

[![Java](https://img.shields.io/badge/Java-17-blue)](https://www.java.com/)  
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.4-brightgreen)](https://spring.io/projects/spring-boot)  
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue)](https://www.postgresql.org/)  

API REST desenvolvida com Spring Boot para gerenciamento de alunos.  
Permite criar, listar, atualizar, buscar e deletar alunos de forma simples e eficiente, seguindo boas práticas de arquitetura e validação de dados.

-------------------------------------------------------------------

## Tecnologias Utilizadas

* Java 17+
* Spring Boot 3+
* Spring Web
* Spring Data JPA
* Hibernate Validator (Jakarta Validation)
* PostgreSQL
* Maven

-------------------------------------------------------------------

## Estrutura do Projeto

A arquitetura do projeto segue um padrão de camadas bem definido:

```bash
src/
└── main/java/com/ghenriqf/spring_boot_api_alunos
    ├── controller/         # Controladores REST (Recebem requisições HTTP)
    ├── dto/                # Objetos de transferência de dados (Request e Response)
    ├── exception/          # Tratamento de exceções personalizadas
    ├── mapper/             # Conversão entre entidades e DTOs
    ├── model/              # Entidades JPA (Modelos do banco de dados)
    ├── repository/         # Interfaces de repositórios JPA (Acesso ao BD)
    └── service/            # Camada de regras de negócio
```

-------------------------------------------------------------------

## Endpoints da API

| Método | Endpoint | Descrição | Corpo da Requisição | Exemplo de Retorno |
| POST | /alunos | Cadastrar um novo aluno | AlunoRequestDTO | AlunoResponseDTO |
| GET | /alunos | Listar todos os alunos | — | Lista de AlunoResponseDTO |
| GET | /alunos/{id} | Buscar aluno por ID | — | AlunoResponseDTO |
| PUT | /alunos/{id} | Atualizar informações do aluno | AlunoRequestDTO | AlunoResponseDTO |
| DELETE | /alunos/{id} | Remover um aluno do sistema | — | AlunoResponseDTO |

### Exemplo de Requisição (POST /alunos)

```json
{
  "nome": "Maria Oliveira",
  "dataNascimento": "2000-03-15",
  "email": "maria.oliveira@example.com",
  "cpf": "12345678909",
  "curso": "Engenharia de Software"
}
```

### Exemplo de Resposta (201 Created)

```json
{
  "id": "b8f29ad7-7c9e-4cb1-9b56-bf6a56a8f9a3",
  "nome": "Maria Oliveira",
  "dataNascimento": "2000-03-15",
  "curso": "Engenharia de Software"
}
```

-------------------------------------------------------------------

## Tratamento de Erros e Regras de Negócio

### Tratamento de Erros

A API retorna respostas padronizadas com mensagens e status HTTP adequados:

| Código | Tipo de Erro | Exemplo de Mensagem |
| 400 | Validação de campos | "O email é obrigatório" |
| 404 | Recurso não encontrado | "Recurso não encontrado com id: {id}" |
| 409 | Recurso duplicado | "email já registrado: email@example.com" |

### Regras de Negócio

* Email e CPF devem ser únicos.
* Todos os campos obrigatórios são validados antes do salvamento.
* O UUID é gerado automaticamente como identificador do aluno.

-------------------------------------------------------------------

## Como Executar o Projeto

1.  Clonar o repositório  
    ```bash
    git clone https://github.com/ghenriqf/spring-boot-api-alunos.git
    cd spring-boot-api-alunos
    ```

2.  Configurar o PostgreSQL  

    * Crie um banco de dados:
      ```sql
      CREATE DATABASE alunosdb;
      ```

    * Configure as credenciais no arquivo `src/main/resources/application.properties`:
      ```
      spring.datasource.url=jdbc:postgresql://localhost:5432/alunosdb
      spring.datasource.username=seu_usuario
      spring.datasource.password=sua_senha
      spring.datasource.driver-class-name=org.postgresql.Driver

      spring.jpa.hibernate.ddl-auto=update
      spring.jpa.show-sql=true
      spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
      ```

3.  Executar com Maven  
    ```bash
    mvn spring-boot:run
    ```

4.  Acessar a API  
    A API estará disponível em: [http://localhost:8080/alunos](http://localhost:8080/alunos)
