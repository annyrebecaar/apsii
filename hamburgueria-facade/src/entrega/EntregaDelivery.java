package entrega;

import modelo.Pedido;
import util.Pausa;

public class EntregaDelivery implements TipoEntrega {
    private String endereco;

    public EntregaDelivery(String endereco) {
        this.endereco = endereco;
    }

    public double calcularTaxa() { return 7.00; }

    public void entregar(Pedido pedido) {
        System.out.println("\n[Entrega] Delivery do pedido #" + pedido.getNumero());
        Pausa.esperar(1000);
        System.out.println("  [x] Pedido embalado");
        Pausa.esperar(1000);
        System.out.println("  [x] Motoboy saiu para: " + endereco);
        Pausa.esperar(1500);
        System.out.println("  [x] Pedido entregue para " + pedido.getCliente());
    }
}
