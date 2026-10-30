public class Main {
    public static void main(String[] args) {
        Carro carro = new Carro("Fusca", 1975, 2);
        Moto moto = new Moto("CG 160", 2023, 160);

        System.out.println(carro.imprimirDetalhes());
        System.out.println(moto.imprimirDetalhes());
    }
}