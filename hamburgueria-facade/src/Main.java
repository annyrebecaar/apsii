import entrega.EntregaDelivery;
import entrega.RetiradaNoBalcao;
import entrega.TipoEntrega;
import facade.PedidoFacade;
import pagamento.FormaPagamento;
import pagamento.PagamentoCartao;
import pagamento.PagamentoDinheiro;
import pagamento.PagamentoPix;
import subsistemas.Cardapio;
import subsistemas.Cozinha;
import subsistemas.Entrega;
import subsistemas.Estoque;
import subsistemas.Pagamento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// classe cliente do facade: usa apenas o PedidoFacade
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PedidoFacade lanchonete = new PedidoFacade(
                new Cardapio(), new Estoque(), new Cozinha(), new Pagamento(), new Entrega());

        System.out.println("=== HAMBURGUERIA DO POO ===");

        while (true) {
            System.out.println("\n1 - Fazer pedido");
            System.out.println("0 - Sair");
            System.out.print("Opcao: ");
            String opcao = sc.nextLine().trim();

            if (opcao.equals("0")) {
                System.out.println("Ate mais!");
                break;
            }
            if (!opcao.equals("1")) {
                System.out.println("Opcao invalida.");
                continue;
            }

            System.out.print("Seu nome: ");
            String nome = sc.nextLine();

            lanchonete.mostrarCardapio();
            System.out.print("Codigos dos itens separados por espaco (ex.: 1 4 5): ");
            List<Integer> codigos = new ArrayList<>();
            try {
                for (String parte : sc.nextLine().trim().split("\\s+")) {
                    codigos.add(Integer.parseInt(parte));
                }
            } catch (NumberFormatException e) {
                System.out.println("Digite so numeros.");
                continue;
            }

            System.out.print("Entrega (1 - Delivery / 2 - Retirada no balcao): ");
            TipoEntrega tipoEntrega;
            if (sc.nextLine().trim().equals("1")) {
                System.out.print("Endereco: ");
                tipoEntrega = new EntregaDelivery(sc.nextLine());
            } else {
                tipoEntrega = new RetiradaNoBalcao();
            }

            System.out.print("Pagamento (1 - Pix / 2 - Cartao / 3 - Dinheiro): ");
            String pag = sc.nextLine().trim();
            FormaPagamento forma;
            if (pag.equals("2")) {
                System.out.print("Cartao (1 - Credito / 2 - Debito): ");
                if (sc.nextLine().trim().equals("1")) {
                    System.out.print("Parcelas (1 a 3): ");
                    try {
                        forma = new PagamentoCartao("credito", Integer.parseInt(sc.nextLine().trim()));
                    } catch (NumberFormatException e) {
                        System.out.println("Numero de parcelas invalido.");
                        continue;
                    }
                } else {
                    forma = new PagamentoCartao("debito", 1);
                }
            } else if (pag.equals("3")) {
                System.out.print("Valor entregue em dinheiro: ");
                try {
                    forma = new PagamentoDinheiro(Double.parseDouble(sc.nextLine().trim().replace(",", ".")));
                } catch (NumberFormatException e) {
                    System.out.println("Valor invalido.");
                    continue;
                }
            } else {
                forma = new PagamentoPix();
            }

            // todo o processo do pedido acontece nesta chamada ao facade
            lanchonete.fazerPedido(nome, codigos, forma, tipoEntrega);
        }
        sc.close();
    }
}
