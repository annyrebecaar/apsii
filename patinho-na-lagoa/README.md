# Patinho na Lagoa - Padrão Strategy

Atividade da disciplina Análise e Projeto de Sistemas II (UNIPÊ), Prof. Raul Andrade.

Implementação do exemplo do livro *Use a Cabeça! Padrões de Projetos* (p. 37-40) usando o padrão **Strategy**.

## Estrutura

```
src/
├── apresentacao/MiniPatinhoNaLagoa.java   (main)
├── patos/Duck.java, MallardDuck.java      (Context)
├── quacks/QuackBehavior.java              (Strategy)
│         Quack.java, Squeak.java, MuteQuack.java   (Concrete Strategies)
└── voos/FlyBehavior.java                  (Strategy)
          FlyWithWings.java, FlyNoWay.java          (Concrete Strategies)
```

## Como compilar e executar

```bash
mkdir out
javac -encoding UTF-8 -d out $(find src -name "*.java")
java -cp out apresentacao.MiniPatinhoNaLagoa
```

Saída esperada:

```
To voando!!!
Quack Quack!
```
