
# Estimate Fence API

Esta API em Java é uma evolução de um projeto que criei anteriormente em Python, que funcionava como um CLI simples para gerar orçamentos.  

Agora, com a versão em Java, trago uma abordagem mais estruturada e escalável, mantendo a simplicidade e eficiência que eram o foco do projeto original.


---

## 📝 Descrição

Este projeto permite gerenciar orçamentos de cercas, incluindo clientes, itens de orçamento e autenticação de usuários.  
A API oferece endpoints protegidos por JWT, garantindo que apenas usuários autenticados possam acessar as operações sensíveis.

---

## 🚀 Tecnologias Utilizadas

- **Java 22**
- **Spring Boot 3**
- **Spring Security** (JWT)
- **Spring Data JPA** (H2 Database / MySQL opcional)
- **Hibernate**
- **Maven**
- **Swagger / OpenAPI** para documentação
- **BCrypt** para hash de senhas

---

## ⚙️ Funcionalidades

- Cadastro de usuários com criptografia de senha (BCrypt)
- Login com geração de token JWT
- CRUD de orçamentos e clientes
- Endpoints protegidos por JWT
- Swagger UI disponível para teste de endpoints
- Banco de dados H2 em memória para testes rápidos

---

## 📌 Endpoints Principais

| Método | Endpoint               | Descrição                  | Protegido? |
|--------|-----------------------|----------------------------|------------|
| POST   | `/auth/login`          | Login de usuário           | ❌          |
| POST   | `/usuarios`            | Criar novo usuário         | ❌          |
| GET    | `/orcamentos`          | Listar todos os orçamentos | ✅          |
| POST   | `/orcamentos`          | Criar novo orçamento       | ✅          |
| GET    | `/clientes`            | Listar clientes            | ✅          |
| POST   | `/clientes`            | Criar cliente              | ✅          |

> Para testar a API visualmente, acesse: `/swagger-ui.html`

---

## 🔑 Usuário de Teste

| Username | Senha | Role  |
|----------|-------|-------|
| admin    | 1234 | ADMIN |

> Senha armazenada com hash BCrypt.

---

## 💻 Como Rodar Localmente

1. Clone o repositório:

```bash
git clone https://github.com/andrelsrn/estimate-fence-api.git
cd estimate-fence-api
````
2. Configure a porta (opcional) no application.properties ou application.yml.

3. Rode a aplicação:
```
mvn spring-boot:run

```
4 . Acesse o Swagger para testar os endpoints:
```
http://localhost:8080/swagger-ui.html
```
---

### 💻 Endpoints principais

POST /auth/login – autenticação

GET /orcamentos – listar orçamentos

POST /orcamentos – criar orçamento

PUT /orcamentos/{id} – atualizar orçamento

DELETE /orcamentos/{id} – deletar orçamento

---

### 🤖 Observações

Banco de dados em memória (H2) para testes

Usuário inicial: admin / senha criada com BCrypt (ver data.sql)

JWT necessário para acessar endpoints protegidos

---

## 🧑‍💻 Contribuição

Contribuições são bem-vindas! Se você encontrou um bug ou tem uma sugestão de melhoria:

1.  Faça um **Fork** do projeto.
2.  Crie uma **Branch** para sua *feature* (`git checkout -b feature/minha-feature`).
3.  Faça o **Commit** das suas alterações.
4.  Envie o **Pull Request**.

---

## 👤 Autor

* **andrelsrn** - https://www.linkedin.com/in/andre-nunes-03866b55/
---
