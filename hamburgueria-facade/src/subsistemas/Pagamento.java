package subsistemas;

import pagamento.FormaPagamento;

// subsistema de pagamento - srp: cobra o valor do pedido
// dip: depende da interface FormaPagamento e nao das classes concretas
public class Pagamento {
    public boolean cobrar(FormaPagamento forma, double valor) {
        System.out.println("\n[Pagamento] Forma escolhida: " + forma.getNome());
        return forma.pagar(valor);
    }
}
