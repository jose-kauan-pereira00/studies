package bancario;

public class ContaCorrente extends Conta {
    public ContaCorrente(String numero, String titular) {
        super(numero, titular);
    }

    @Override
    public void exibirTipoConta() {
        System.out.println("Conta Corrente");
    }
}