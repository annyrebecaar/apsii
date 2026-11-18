package subsistemas;

import modelo.Pedido;
import modelo.Produto;
import util.Pausa;

// subsistema da cozinha - srp: prepara os itens do pedido
public class Cozinha {
    public void preparar(Pedido pedido) {
        System.out.println("\n[Cozinha] Preparando o pedido #" + pedido.getNumero() + "...");
        for (Produto p : pedido.getItens()) {
            Pausa.esperar(1000);
            System.out.println("  [x] " + p.getNome() + " pronto");
        }
    }
}
