package pizzas;

import ingredientes.*;

public abstract class Pizza {
    String name;
    Dough dough;
    Sauce sauce;
    Veggies veggies[];
    Cheese cheese;
    Pepperoni pepperoni;
    Clam clam;

    public abstract void prepare();

    public void bake() {
        System.out.println("Assar por 25 minutos a 350°");
    }

    public void cut() {
        System.out.println("Cortar a pizza em fatias diagonais");
    }

    public void box() {
        System.out.println("Colocar a pizza na caixa oficial da pizzaria");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("---- " + name + " ----\n");
        if (dough != null) result.append(dough).append("\n");
        if (sauce != null) result.append(sauce).append("\n");
        if (cheese != null) result.append(cheese).append("\n");
        if (veggies != null) {
            for (int i = 0; i < veggies.length; i++) {
                result.append(veggies[i]);
                if (i < veggies.length - 1) result.append(", ");
            }
            result.append("\n");
        }
        if (clam != null) result.append(clam).append("\n");
        if (pepperoni != null) result.append(pepperoni).append("\n");
        return result.toString();
    }
}
