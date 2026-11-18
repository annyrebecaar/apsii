package pagamento;

// lsp: pode substituir qualquer FormaPagamento
public class PagamentoPix implements FormaPagamento {
    public boolean pagar(double valor) {
        System.out.println("[Pix] QR Code gerado. Pagamento de R$ " + String.format("%.2f", valor) + " confirmado!");
        return true;
    }

    public String getNome() { return "Pix"; }
}
