package bancario;

public class Investimento {
    private String nome;
    private double valor;
    private double taxa; // em %

    public Investimento(String nome, double valor, double taxa) {
        this.nome = nome;
        this.valor = valor;
        this.taxa = taxa;
        render();
    }

    public void render() {
        valor += valor * taxa / 100;
    }

    @Override
    public String toString() {
        return nome + ": R$ " + String.format("%.2f", valor) + " (taxa: " + taxa + "%)";
    }
}