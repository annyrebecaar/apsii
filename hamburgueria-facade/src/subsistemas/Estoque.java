package subsistemas;

import java.util.HashMap;
import java.util.Map;
import modelo.Produto;

// subsistema de estoque - srp: controla a quantidade de cada produto
public class Estoque {
    private Map<Integer, Integer> quantidades = new HashMap<>();

    public Estoque() {
        quantidades.put(1, 10);
        quantidades.put(2, 10);
        quantidades.put(3, 2);   // x-tudo com estoque baixo
        quantidades.put(4, 15);
        quantidades.put(5, 20);
        quantidades.put(6, 5);
    }

    public boolean temDisponivel(Produto produto) {
        Integer qtd = quantidades.get(produto.getCodigo());
        return qtd != null && qtd > 0;
    }

    public void darBaixa(Produto produto) {
        int qtd = quantidades.get(produto.getCodigo());
        quantidades.put(produto.getCodigo(), qtd - 1);
    }

    public void devolver(Produto produto) {
        int qtd = quantidades.get(produto.getCodigo());
        quantidades.put(produto.getCodigo(), qtd + 1);
    }
}
