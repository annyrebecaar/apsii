package entrega;

import modelo.Pedido;
import util.Pausa;

public class RetiradaNoBalcao implements TipoEntrega {
    public double calcularTaxa() { return 0; }

    public void entregar(Pedido pedido) {
        System.out.println("\n[Entrega] Retirada do pedido #" + pedido.getNumero());
        Pausa.esperar(1000);
        System.out.println("  [x] Pedido embalado");
        Pausa.esperar(1000);
        System.out.println("  [x] Pedido no balcao. Chamando " + pedido.getCliente() + "!");
    }
}
