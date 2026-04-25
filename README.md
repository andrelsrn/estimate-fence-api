# 🧱 Estimate Fence API

Uma API REST moderna para gerenciamento de orçamentos de cercas, clientes e autenticação de usuários, desenvolvida com foco em escalabilidade, segurança e boas práticas de arquitetura backend.

Este projeto é uma evolução de um sistema anterior feito em Python (CLI), agora reescrito em Java com Spring Boot para suportar uma arquitetura mais robusta e profissional.

---

## 🚀 Visão Geral

A **Estimate Fence API** permite criar e gerenciar orçamentos completos de cercas, incluindo clientes, itens de orçamento e controle de acesso via autenticação JWT.

A aplicação foi projetada seguindo padrões de API REST e boas práticas de segurança e organização de código, simulando um cenário real de sistema corporativo.

---

## 🧠 Arquitetura e Destaques Técnicos

* Arquitetura em camadas (Controller, Service, Repository)
* Autenticação e autorização com **JWT (Spring Security)**
* Criptografia de senha com **BCrypt**
* Banco de dados relacional com **Spring Data JPA**
* **PostgreSQL em container Docker (ambiente local e produção)**
* Docker para padronização de ambiente
* Documentação interativa com **Swagger / OpenAPI**

---

## 🛠️ Tecnologias Utilizadas

* Java 22
* Spring Boot 3
* Spring Security + JWT
* Spring Data JPA
* Hibernate
* PostgreSQL
* Docker & Docker Compose
* Maven
* Swagger / OpenAPI

---

## 🔐 Segurança

* Autenticação via **JWT Token**
* Rotas protegidas para usuários autenticados
* Senhas armazenadas com **hash BCrypt**
* Controle de acesso por role (USER / ADMIN)

---

## ⚙️ Funcionalidades

### 👤 Usuários

* Cadastro de usuários
* Login com geração de token JWT

### 📦 Orçamentos

* Criar orçamento
* Listar orçamentos
* Atualizar orçamento
* Remover orçamento

### 👥 Clientes

* Cadastro de clientes
* Listagem de clientes

### 🔒 Segurança

* Endpoints protegidos via JWT

---

## 📌 Endpoints Principais

| Método | Endpoint         | Descrição               | Protegido |
| ------ | ---------------- | ----------------------- | --------- |
| POST   | /auth/login      | Autenticação de usuário | ❌         |
| POST   | /usuarios        | Criar usuário           | ❌         |
| GET    | /orcamentos      | Listar orçamentos       | ✅         |
| POST   | /orcamentos      | Criar orçamento         | ✅         |
| PUT    | /orcamentos/{id} | Atualizar orçamento     | ✅         |
| DELETE | /orcamentos/{id} | Remover orçamento       | ✅         |
| GET    | /clientes        | Listar clientes         | ✅         |
| POST   | /clientes        | Criar cliente           | ✅         |

---

## 📚 Documentação (Swagger)

Após rodar o projeto, acesse:

```
http://localhost:8080/swagger-ui/index.html
```

---

## 👤 Usuário de Teste

| Username | Senha | Role  |
| -------- | ----- | ----- |
| admin    | 1234  | ADMIN |

> Senha armazenada com hash BCrypt

---

## 💻 Como Rodar o Projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/andrelsrn/estimate-fence-api.git
cd estimate-fence-api
```

### 2. Subir banco com Docker

```bash
docker-compose up -d
```

### 3. Rodar aplicação

```bash
mvn spring-boot:run
```

### 4. Acessar Swagger

```
http://localhost:8080/swagger-ui/index.html
```

---

## 🌐 Deploy

🔗 API em produção:

> **https://estimate-fence-api.onrender.com/swagger-ui/index.html**

> Banco de dados PostgreSQL em produção via Docker

---

## 🖼️ Screenshots

### Dashboard / Front-end

> <img width="1209" height="877" alt="Captura de tela 2026-04-24 174144" src="https://github.com/user-attachments/assets/d153f7ba-acf2-4c65-82e1-42202f01f998" />




### Swagger UI

<img width="1607" height="866" alt="Captura de tela 2026-04-24 215830" src="https://github.com/user-attachments/assets/eb6b63d0-6122-45f8-bb32-307c82907bd2" />


---

## 📈 Evolução do Projeto

Este projeto representa uma evolução significativa do meu aprendizado:

* Antes: CLI em Python para geração de orçamentos
* Agora: API REST completa com autenticação, PostgreSQL, Docker e arquitetura profissional

---

## 🧑‍💻 Contribuição

Contribuições são bem-vindas!

1. Fork o projeto
2. Crie uma branch (`git checkout -b feature/minha-feature`)
3. Commit suas alterações (`git commit -m 'feat: minha feature'`)
4. Push na branch (`git push origin feature/minha-feature`)
5. Abra um Pull Request

---

## 🔥 Autor

Desenvolvido por **André Nunes**

Projeto focado em aprendizado de backend, arquitetura de APIs, segurança e boas práticas com Spring Boot e Docker.
