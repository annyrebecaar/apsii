package pagamento;

// isp: interface pequena, so com o necessario para pagar
// ocp: uma nova forma de pagamento e uma nova classe,
// sem alterar o codigo existente
public interface FormaPagamento {
    boolean pagar(double valor);
    String getNome();
}
