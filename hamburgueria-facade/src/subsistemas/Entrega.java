package subsistemas;

import entrega.TipoEntrega;
import modelo.Pedido;

// subsistema de entrega - srp: envia o pedido ao cliente
// dip: depende da interface TipoEntrega
public class Entrega {
    public void enviar(Pedido pedido, TipoEntrega tipo) {
        tipo.entregar(pedido);
    }
}
