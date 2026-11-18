package modelo;

import java.util.ArrayList;
import java.util.List;

// srp: guarda os itens do pedido e calcula o subtotal
public class Pedido {
    private static int contador = 1;

    private int numero;
    private String cliente;
    private List<Produto> itens = new ArrayList<>();

    public Pedido(String cliente) {
        this.numero = contador++;
        this.cliente = cliente;
    }

    public void adicionarItem(Produto produto) {
        itens.add(produto);
    }

    public double getSubtotal() {
        double total = 0;
        for (Produto p : itens) {
            total += p.getPreco();
        }
        return total;
    }

    public int getNumero() { return numero; }
    public String getCliente() { return cliente; }
    public List<Produto> getItens() { return itens; }
}
