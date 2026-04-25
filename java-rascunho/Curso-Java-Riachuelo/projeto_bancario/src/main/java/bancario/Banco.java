package bancario;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Conta> contas = new ArrayList<>();

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public Conta buscarConta(String numero) {
        for(Conta c : contas) {
            if(c.getNumero().equals(numero)) return c;
        }
        return null;
    }

    public void listarContas() {
        contas.forEach(c -> System.out.println(c.getNumero() + " - " + c.getTitular()));
    }
}