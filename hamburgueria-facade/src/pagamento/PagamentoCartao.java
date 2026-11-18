package pagamento;

// lsp: pode substituir qualquer FormaPagamento
public class PagamentoCartao implements FormaPagamento {
    private String tipo;     // "credito" ou "debito"
    private int parcelas;

    public PagamentoCartao(String tipo, int parcelas) {
        this.tipo = tipo;
        this.parcelas = parcelas;
    }

    public boolean pagar(double valor) {
        if (tipo.equals("debito")) {
            System.out.println("[Cartao] Debito aprovado: R$ " + String.format("%.2f", valor));
            return true;
        }
        // no credito a lanchonete parcela em ate 3x sem juros
        if (parcelas < 1 || parcelas > 3) {
            System.out.println("[Cartao] Parcelamento permitido somente de 1x a 3x. Pagamento recusado.");
            return false;
        }
        System.out.println("[Cartao] Credito aprovado: " + parcelas + "x de R$ "
                + String.format("%.2f", valor / parcelas) + " sem juros");
        return true;
    }

    public String getNome() { return "Cartao de " + tipo; }
}
