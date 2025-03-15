# Sistema de Controle de Inventário

## O que é este projeto?

O **Sistema de Controle de Inventário** é uma aplicação Java construída com **Spring Boot** que ajuda a gerenciar produtos em diferentes estágios do inventário. Ele organiza os produtos em **boards** (quadros) e **colunas** (etapas), permitindo que você crie, mova, bloqueie ou desbloqueie produtos conforme necessário.

Durante o desenvolvimento, o sistema usa o banco de dados **H2** (em memória) para facilitar testes rápidos. Para produção, você pode configurar o sistema para usar **MySQL**, garantindo persistência dos dados.

---

## Como Funciona?

Imagine que você tem um quadro branco dividido em colunas, como **"Estoque"**, **"Em Uso"**, **"Devolvido"** e **"Descartado"**. Cada produto começa na coluna inicial (**"Estoque"**) e pode ser movido entre as colunas até chegar ao estado final (**"Descartado"**). 

Você também pode:
- **Bloquear/Desbloquear Produtos:** Impedir que um produto seja movido enquanto está bloqueado.
- **Visualizar Dados:** Durante o desenvolvimento, você pode acessar o console do H2 para ver os dados diretamente no navegador.

---

## Diagrama de Classes

Abaixo está o diagrama de classes que representa a estrutura do sistema:

```mermaid
classDiagram
    class Board {
        +Long id
        +String nome
        +List~Coluna~ colunas
        +adicionarColuna(Coluna coluna)
    }

    class Coluna {
        +Long id
        +String nome
        +String tipo
        +int ordem
        +Board board
        +List~Produto~ produtos
    }

    class Produto {
        +Long id
        +String nome
        +String descricao
        +int quantidade
        +boolean bloqueado
        +String motivoBloqueio
        +Coluna coluna
    }

    Board "1" -- "0..*" Coluna: contém
    Coluna "1" -- "0..*" Produto: contém
