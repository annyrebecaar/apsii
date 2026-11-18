# Hamburgueria do POO — Padrão Facade

Sistema de pedidos de uma hamburgueria feito em Java (console) para a disciplina de Programação Orientada a Objetos.
O cliente escolhe os lanches, a forma de entrega e a forma de pagamento. O sistema confere o estoque, cobra, manda para a cozinha e entrega.

## Como rodar

### 1. Pré-requisito
Ter o Java (JDK 17 ou mais novo) instalado. Para conferir, abra o terminal e digite:

```bash
java -version
```

Se aparecer a versão, está tudo certo. Se não, instale o JDK em https://adoptium.net.

### 2. Baixar o projeto

```bash
git clone https://github.com/annyrebecaar/hamburgueria-facade.git
cd hamburgueria-facade
```

### 3. Compilar
No macOS ou Linux:

```bash
javac -d out $(find src -name "*.java")
```

No Windows (PowerShell):

```powershell
javac -d out (Get-ChildItem -Recurse src -Filter *.java).FullName
```

Esse comando cria a pasta `out/` com os arquivos compilados.

### 4. Executar

```bash
java -cp out Main
```

### 5. Usar o sistema
1. Digite `1` para fazer um pedido.
2. Digite seu nome.
3. Digite os códigos dos itens separados por espaço (ex.: `1 4 5`).
4. Escolha `1` para delivery (e digite o endereço) ou `2` para retirada no balcão.
5. Escolha a forma de pagamento: `1` Pix, `2` Cartão (crédito em até 3x ou débito) ou `3` Dinheiro (valor entregue).
6. Digite `0` para sair.

### Casos para testar
| Teste | O que digitar | Resultado esperado |
|---|---|---|
| Pedido normal | itens `1 4 5`, delivery, dinheiro `50` | mostra o troco e sai para entrega |
| Cartão de crédito | itens `2 6`, retirada, crédito em `2` parcelas | aprovado em 2x sem juros |
| Cartão de débito | itens `1 5`, retirada, débito | débito aprovado |
| Parcelas demais | crédito em `5` parcelas | pagamento recusado, pedido cancelado |
| Estoque acabou | itens `3 3 3` | "Desculpe, acabou: X-Tudo" |
| Dinheiro insuficiente | dinheiro `5` | mostra quanto falta |

## Estrutura

```
src/
├── Main.java                  -> cliente do Facade (menu no console)
├── facade/PedidoFacade.java   -> a fachada: fazerPedido(...)
├── modelo/                    -> Produto, Pedido
├── subsistemas/               -> Cardapio, Estoque, Cozinha, Pagamento, Entrega
├── pagamento/                 -> FormaPagamento (interface), Pix, Cartao (credito/debito), Dinheiro
├── entrega/                   -> TipoEntrega (interface), Delivery, Retirada no balcão
└── util/Pausa.java            -> pausa para mostrar as etapas uma de cada vez
```

## O padrão escolhido: Facade

Fazer um pedido envolve cinco partes do sistema: **Cardápio, Estoque, Cozinha, Pagamento e Entrega**, chamadas numa ordem certa e com regras (se o pagamento falha, o estoque volta). Sem o Facade, o `Main` teria que conhecer e chamar todas essas classes.

Com o Facade, o `Main` faz uma única chamada:

```java
lanchonete.fazerPedido(nome, codigos, formaPagamento, tipoEntrega);
```

e a classe `PedidoFacade` coordena os subsistemas por trás.

### Por que é o mais adequado
- O problema é exatamente o que o Facade resolve: **vários subsistemas que precisam trabalhar juntos num fluxo**, e um cliente que só quer o resultado ("quero meu pedido").
- Diminui o acoplamento: se a Cozinha mudar, o `Main` não muda.
- Fica parecido com a vida real: o cliente fala só com o atendente, não vai na cozinha nem no estoque.

### Outros padrões que poderiam ser usados
- **Strategy**: já aparece de leve no projeto (`FormaPagamento` e `TipoEntrega` são estratégias trocáveis). Serviria para variar o *jeito* de pagar ou entregar, mas sozinho não organiza o fluxo inteiro do pedido.
- **Mediator**: também centraliza a comunicação, mas é indicado quando os objetos conversam entre si nos dois sentidos. Aqui o fluxo é de mão única, então seria mais complicado que o necessário.
- **Template Method**: daria para definir os passos do pedido numa classe base, mas exigiria herança e não esconderia os subsistemas do cliente.

## Princípios SOLID aplicados

| Princípio | Onde |
|---|---|
| **S** — Responsabilidade Única | Cada subsistema faz uma coisa só: `Cardapio` lista produtos, `Estoque` controla quantidades, `Cozinha` prepara, `Pagamento` cobra, `Entrega` entrega. |
| **O** — Aberto/Fechado | Para aceitar vale-refeição ou entrega por app, basta criar uma classe nova que implementa `FormaPagamento` ou `TipoEntrega`. Nada do que existe é alterado. |
| **L** — Substituição de Liskov | `PagamentoPix`, `PagamentoCartao` e `PagamentoDinheiro` podem ser usados em qualquer lugar que espera `FormaPagamento`, e o sistema continua funcionando. |
| **I** — Segregação de Interfaces | As interfaces são pequenas: `FormaPagamento` só tem `pagar` e `getNome`; `TipoEntrega` só tem `calcularTaxa` e `entregar`. |
| **D** — Inversão de Dependência | `Pagamento` e `Entrega` dependem das interfaces, não das classes concretas. O `PedidoFacade` recebe os subsistemas pelo construtor. |

## Equipe
- ana larissa 
- anny rebeca
