# Rocketseat TodoList

Uma TodoList desenvolvida no curso gratuito de java da Rocketseat


## Documentação da API

#### Cadastrar um usuário

```http
  POST /usuarios/register
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `name` | `string` | **Obrigatório**. |
| `username` | `string` | **Obrigatório**. |
| `password` | `string` | **Obrigatório**. |

#### Criar uma task

```http
  POST /task
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `description`      | `string` | **Obrigatório**. |
| `tittle`      | `string` | **Obrigatório**. |
| `priority`      | `string` | **Obrigatório**. |
| `starting_at`      | `LocalDateTime` | **Obrigatório**. |
| `ended_at`      | `LocalDateTime` | **Obrigatório**. |

obs: Utilizar o basic auth para logar no usuario que foi cadastrado anteriormente.

### Listar todas as task do usuario logado

```http
  GET /task
```

| Atributos   | Tipo       |
| :---------- | :--------- | 
| `description`      | `string` | 
| `tittle`      | `string` |  
| `priority`      | `string` | 
| `starting_at`      | `LocalDateTime` | 
| `ended_at`      | `LocalDateTime` | 

obs: Utilizar o basic auth para logar no usuario que foi cadastrado anteriormente.

### Modificar dados da task do usuário logado

```http
  PUT /task/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `description`      | `string` | **Optativo**. |
| `tittle`      | `string` | **Optativo**. |
| `priority`      | `string` | **Optativo**. |

obs: Utilizar o basic auth para logar no usuario que foi cadastrado anteriormente.