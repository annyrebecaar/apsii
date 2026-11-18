package subsistemas;

import java.util.ArrayList;
import java.util.List;
import modelo.Produto;

// subsistema do cardapio - srp: guarda e busca os produtos a venda
public class Cardapio {
    private List<Produto> produtos = new ArrayList<>();

    public Cardapio() {
        produtos.add(new Produto(1, "X-Burguer", 18.00));
        produtos.add(new Produto(2, "X-Bacon", 22.00));
        produtos.add(new Produto(3, "X-Tudo", 28.00));
        produtos.add(new Produto(4, "Batata frita", 12.00));
        produtos.add(new Produto(5, "Refrigerante lata", 6.00));
        produtos.add(new Produto(6, "Milkshake", 15.00));
    }

    public void mostrar() {
        System.out.println("\n===== CARDAPIO =====");
        for (Produto p : produtos) {
            System.out.println(p);
        }
    }

    public Produto buscar(int codigo) {
        for (Produto p : produtos) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }
}
