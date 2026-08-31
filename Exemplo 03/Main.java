import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Cadastro Livro
        System.out.println("Cadastro de livro");
        Livro livro = new Livro();

        System.out.print("Digite o nome do livro: ");
        String nomeLivro = scanner.nextLine();
        livro.setNome(nomeLivro);

        System.out.print("Digite o preço do livro: ");
        double precoLivro = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.print("Digite o autor do livro: ");
        String autorLivro = scanner.nextLine();
        livro.setAutor(autorLivro);

        // 2. Cadastro CD
        System.out.println("\n Cadastro de CD");
        CD cd = new CD();

        System.out.print("Digite o nome do CD: ");
        String nomeCD = scanner.nextLine();
        cd.setNome(nomeCD);

        System.out.print("Digite o preço do CD: ");
        double precoCD = scanner.nextDouble();
        
        System.out.print("Digite o número de faixas do CD: ");
        int faixasCD = scanner.nextInt();
        cd.setNumFaixas(faixasCD);

        // Envia os dados coletados para o objeto CD
        cd.setPreco(precoCD); 
        livro.setPreco(precoLivro);

        // 3. Exibição das informações do CD cadastrado
    System.out.println("\n Informacoes do cadastro");
        cd.exibeInformacoes();

        // Fecha o scanner para liberar os recursos do sistema
        scanner.close();
    }
}
