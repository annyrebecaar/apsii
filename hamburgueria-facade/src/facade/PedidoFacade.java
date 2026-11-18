package facade;

import entrega.TipoEntrega;
import modelo.Pedido;
import modelo.Produto;
import pagamento.FormaPagamento;
import subsistemas.Cardapio;
import subsistemas.Cozinha;
import subsistemas.Entrega;
import subsistemas.Estoque;
import subsistemas.Pagamento;

import java.util.List;

// padrao facade
// a classe oferece um unico metodo, fazerPedido, e coordena
// os cinco subsistemas na ordem correta.
// quem usa o facade nao precisa conhecer estoque, cozinha, etc.
public class PedidoFacade {
    private Cardapio cardapio;
    private Estoque estoque;
    private Cozinha cozinha;
    private Pagamento pagamento;
    private Entrega entrega;

    // dip: os subsistemas sao recebidos pelo construtor
    public PedidoFacade(Cardapio cardapio, Estoque estoque, Cozinha cozinha,
                        Pagamento pagamento, Entrega entrega) {
        this.cardapio = cardapio;
        this.estoque = estoque;
        this.cozinha = cozinha;
        this.pagamento = pagamento;
        this.entrega = entrega;
    }

    public void mostrarCardapio() {
        cardapio.mostrar();
    }

    public boolean fazerPedido(String cliente, List<Integer> codigos,
                               FormaPagamento forma, TipoEntrega tipoEntrega) {
        Pedido pedido = new Pedido(cliente);

        // 1. cardapio e estoque: monta o pedido
        for (int codigo : codigos) {
            Produto produto = cardapio.buscar(codigo);
            if (produto == null) {
                System.out.println("Produto " + codigo + " nao existe no cardapio.");
                devolverItens(pedido);
                return false;
            }
            if (!estoque.temDisponivel(produto)) {
                System.out.println("Desculpe, acabou: " + produto.getNome());
                devolverItens(pedido);
                return false;
            }
            estoque.darBaixa(produto);
            pedido.adicionarItem(produto);
        }

        if (pedido.getItens().isEmpty()) {
            System.out.println("Pedido vazio.");
            return false;
        }

        // 2. calcula o total
        double taxa = tipoEntrega.calcularTaxa();
        double total = pedido.getSubtotal() + taxa;
        System.out.println("\nPedido #" + pedido.getNumero() + " de " + cliente);
        System.out.println("Subtotal: R$ " + String.format("%.2f", pedido.getSubtotal()));
        System.out.println("Taxa de entrega: R$ " + String.format("%.2f", taxa));
        System.out.println("TOTAL: R$ " + String.format("%.2f", total));

        // 3. pagamento
        if (!pagamento.cobrar(forma, total)) {
            System.out.println("Pedido cancelado: pagamento nao aprovado.");
            devolverItens(pedido);
            return false;
        }

        // 4. cozinha
        cozinha.preparar(pedido);

        // 5. entrega
        entrega.enviar(pedido, tipoEntrega);

        System.out.println("\nPedido #" + pedido.getNumero() + " finalizado com sucesso!");
        return true;
    }

    // em caso de falha, os itens voltam para o estoque
    private void devolverItens(Pedido pedido) {
        for (Produto p : pedido.getItens()) {
            estoque.devolver(p);
        }
    }
}
