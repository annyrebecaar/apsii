# Pizzaria Objetolândia - Padrão Abstract Factory

Atividade de APS II: código do livro *Use a Cabeça! Padrões de Projetos* (p. 129-134).

- `ingredientes/`: interfaces (Dough, Sauce, Cheese, Veggies, Pepperoni, Clam) e implementações
- `fabricas/`: `PizzaIngredientFactory` (Abstract Factory) e as fábricas de Nova York e Chicago
- `pizzas/`: `Pizza` e as pizzas, que recebem a fábrica no construtor
- `lojas/`: `PizzaStore`, `NYStylePizzaStore`, `ChicagoStylePizzaStore`
- `apresentacao/PizzaTestDrive.java`: main

```bash
mkdir out
javac -encoding UTF-8 -d out $(find src -name "*.java")
java -cp out apresentacao.PizzaTestDrive
```
