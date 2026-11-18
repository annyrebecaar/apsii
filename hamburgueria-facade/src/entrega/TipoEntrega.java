package entrega;

import modelo.Pedido;

// ocp e isp: cada tipo de entrega e uma classe que implementa esta interface
public interface TipoEntrega {
    double calcularTaxa();
    void entregar(Pedido pedido);
}
