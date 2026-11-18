package pagamento;

public class PagamentoDinheiro implements FormaPagamento {
    private double valorRecebido;

    public PagamentoDinheiro(double valorRecebido) {
        this.valorRecebido = valorRecebido;
    }

    public boolean pagar(double valor) {
        if (valorRecebido < valor) {
            System.out.println("[Dinheiro] Valor insuficiente. Faltam R$ " + String.format("%.2f", valor - valorRecebido));
            return false;
        }
        System.out.println("[Dinheiro] Recebido R$ " + String.format("%.2f", valorRecebido)
                + ". Troco: R$ " + String.format("%.2f", valorRecebido - valor));
        return true;
    }

    public String getNome() { return "Dinheiro"; }
}
