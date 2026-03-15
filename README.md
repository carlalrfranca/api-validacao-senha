# API Validação de senha

Esse projeto expõe uma API REST para validação de senhas.
A API recebe uma String representando a senha a ser validada e retorna um booleano indicando se a senha é válida ou não, de acordo com um conjunto de regras de segurança.
Caso a senha não seja válida, a API retorna uma mensagem de erro indicando qual regra foi quebrada.

## Regras de validação

A senha recebida será considerada válida caso:
- Possua pelo menos 9 caracteres
- Contenha pelo menos:
    - 1 letra maiúscula
    - 1 letra minúscula
    - 1 dígito
    - 1 caractere especial do conjunto: `!@#$%^&*()-+`
- Não possua caracteres repetidos
- Não contenha espaços em branco
- Contenha apenas caracteres alfanuméricos e o conjunto explícito de caracteres especiais definidos

## Uso da API

### Endpoint

POST `/senhas/validacoes`

URL base:

```
http://localhost:8080
```

---

### Senha válida

Exemplo de requisição:

```bash
curl -X POST http://localhost:8080/api-password/validate \
  -H "Content-Type: application/json" \
  -d '{"senha":"AbTp9!fok"}'
```

Resposta esperada:

```json
{
  "valido": true,
  "messagem": "Senha validada"
}
```

---

### Senha inválida

Exemplo de requisição:

```bash
curl -X POST http://localhost:8080/api-password/validate \
  -H "Content-Type: application/json" \
  -d '{"senha":"AbTp9 fok"}'
```

Resposta esperada:

```json
{
  "valido": false,
  "mensagem": "A senha deve conter no mínimo 9 caracteres."
}
```

---

## Como executar o projeto

### Requisitos

- Java 17 ou Java 21
- Maven 3.9+

### Build

```
mvn clean install
```

### Executar

```
mvn spring-boot:run
```

### Referências

- Sobre o case: https://github.com/itidigital/backend-challenge
- Sobre testes unitários: https://zup.com.br/blog/testes-unitarios/ , https://www.freecodecamp.org/news/java-unit-testing/ , https://zup.com.br/blog/testes-unitarios/
- Diferenças entre teste unitário e integrado: https://pt.stackoverflow.com/questions/115146/qual-a-diferen%C3%A7a-entre-teste-unit%C3%A1rio-e-teste-integrado
- Sobre princípios SOLID: https://pt.stackoverflow.com/questions/178718/o-que-s%C3%A3o-os-princ%C3%ADpios-solid
- Sobre Composição: https://www.geeksforgeeks.org/java/composite-design-pattern-in-java/