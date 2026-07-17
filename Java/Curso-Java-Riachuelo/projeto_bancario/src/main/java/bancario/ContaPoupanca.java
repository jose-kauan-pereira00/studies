package bancario;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(String numero, String titular) {
        super(numero, titular);
    }

    @Override
    public void exibirTipoConta() {
        System.out.println("Conta Poupança");
    }
}