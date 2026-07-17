package bancario;

import java.util.ArrayList;
import java.util.List;

public abstract class Conta {
    private String numero;
    private String titular;
    private double saldo;
    private List<String> historico;
    private List<Investimento> investimentos;

    public Conta(String numero, String titular) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0;
        this.historico = new ArrayList<>();
        this.investimentos = new ArrayList<>();
    }

    public String getNumero() { return numero; }
    public String getTitular() { return titular; }
    public double getSaldo() { return saldo; }
    public void setSaldo(double saldo) { this.saldo = saldo; }
    public List<String> getHistorico() { return historico; }
    public List<Investimento> getInvestimentos() { return investimentos; }

    public void depositar(double valor) {
        saldo += valor;
        historico.add(TipoTransacao.DEPOSITO + ": +R$ " + valor);
    }

    public boolean sacar(double valor) {
        if(saldo >= valor) {
            saldo -= valor;
            historico.add(TipoTransacao.SAQUE + ": -R$ " + valor);
            return true;
        }
        return false;
    }

    public boolean transferir(Conta destino, double valor) {
        if(sacar(valor)) {
            destino.depositar(valor);
            historico.add(TipoTransacao.TRANSFERENCIA + ": -R$ " + valor + " para " + destino.getNumero());
            destino.getHistorico().add(TipoTransacao.TRANSFERENCIA + ": +R$ " + valor + " de " + this.getNumero());
            return true;
        }
        return false;
    }

    public void investir(String nome, double valor, double taxa) {
        if(sacar(valor)) {
            Investimento inv = new Investimento(nome, valor, taxa);
            investimentos.add(inv);
            historico.add(TipoTransacao.INVESTIMENTO + ": " + inv);
        }
    }

    public abstract void exibirTipoConta();
}