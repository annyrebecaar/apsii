public class Veiculo {
    public String modelo;
    public int ano;

    public Veiculo(String modelo, int ano) {
        this.modelo = modelo;
        this.ano = ano;
    }

    public String imprimirDetalhes() {
        return "Modelo: " + this.modelo + ", Ano: " + this.ano;
    }
}