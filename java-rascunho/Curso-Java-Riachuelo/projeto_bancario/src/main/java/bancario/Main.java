package bancario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Banco banco = new Banco();
        boolean rodando = true;

        while(rodando) {
            System.out.println("\n=== BANCO SIMPLES ===");
            System.out.println("1 - Criar Conta Corrente");
            System.out.println("2 - Criar Conta Poupança");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Transferir via PIX");
            System.out.println("6 - Ver Histórico");
            System.out.println("7 - Criar Investimento");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch(opcao) {
                case 1 -> {
                    System.out.print("Número da conta: ");
                    String numero = sc.nextLine();
                    System.out.print("Titular: ");
                    String titular = sc.nextLine();
                    banco.adicionarConta(new ContaCorrente(numero, titular));
                }
                case 2 -> {
                    System.out.print("Número da conta: ");
                    String numero = sc.nextLine();
                    System.out.print("Titular: ");
                    String titular = sc.nextLine();
                    banco.adicionarConta(new ContaPoupanca(numero, titular));
                }
                case 3 -> {
                    System.out.print("Número da conta: ");
                    Conta conta = banco.buscarConta(sc.nextLine());
                    if(conta != null) {
                        System.out.print("Valor do depósito: ");
                        conta.depositar(sc.nextDouble());
                    } else System.out.println("Conta não encontrada!");
                }
                case 4 -> {
                    System.out.print("Número da conta: ");
                    Conta conta = banco.buscarConta(sc.nextLine());
                    if(conta != null) {
                        System.out.print("Valor do saque: ");
                        conta.sacar(sc.nextDouble());
                    } else System.out.println("Conta não encontrada!");
                }
                case 5 -> {
                    System.out.print("Conta de origem: ");
                    Conta origem = banco.buscarConta(sc.nextLine());
                    System.out.print("Conta destino: ");
                    Conta destino = banco.buscarConta(sc.nextLine());
                    if(origem != null && destino != null) {
                        System.out.print("Valor da transferência: ");
                        origem.transferir(destino, sc.nextDouble());
                    } else System.out.println("Conta(s) não encontrada(s)!");
                }
                case 6 -> {
                    System.out.print("Número da conta: ");
                    Conta conta = banco.buscarConta(sc.nextLine());
                    if(conta != null) {
                        System.out.println("--- HISTÓRICO ---");
                        conta.getHistorico().forEach(System.out::println);
                        if(!conta.getInvestimentos().isEmpty()) {
                            System.out.println("--- INVESTIMENTOS ---");
                            conta.getInvestimentos().forEach(System.out::println);
                        }
                    } else System.out.println("Conta não encontrada!");
                }
                case 7 -> {
                    System.out.print("Número da conta: ");
                    Conta conta = banco.buscarConta(sc.nextLine());
                    if(conta != null) {
                        System.out.print("Nome do investimento: ");
                        String nome = sc.nextLine();
                        System.out.print("Valor a investir: ");
                        double valor = sc.nextDouble();
                        System.out.print("Taxa de rendimento (%): ");
                        double taxa = sc.nextDouble();
                        conta.investir(nome, valor, taxa);
                    } else System.out.println("Conta não encontrada!");
                }
                case 0 -> rodando = false;
                default -> System.out.println("Opção inválida!");
            }
        }
        sc.close();
    }
}