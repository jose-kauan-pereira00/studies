import src.Sistema;
import src.Usuario;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Sistema sis = new Sistema();
		sis.cadastrarUsuario("admim", "123.456.789.11", "chave", "12 3456-789");
		Usuario usu = sis.retornaUsu("123.456.789.11");
		usu.somaSaldo(1000000000);

		System.out.println("================= ==== Seja Bem Vindo ao Sistema Bancário! ===== ===============");
		System.out.println("Escolha Uma Opção Para Prosseguir: ");
		System.out.println("1 - Vizualizar Pessoas no Sistema.");
		System.out.println("2 - Cadastrar Pessoa No Sistema. ");
		System.out.println("3 - Realizar Trasferencia.");
		System.out.println("0 - Sair do Sistema.");


		while(true){
			int escolha;
			System.out.println("Por favor, Digite uma operação que você deseja fazer: ");
			escolha = sc.nextInt();
			if (escolha == 0){
				break;
			}else{
				switch (escolha){
				case 1:
					exibirSistema(sis);
					break;
				case 2:
					cadastrarUsuario(sis);
					break;
				default:
					System.out.println("Sem funcionalidade até o momento!");
			}

			}

		}
	}

	public static void cadastrarUsuario(Sistema sis){
		Scanner sc = new Scanner(System.in);
		System.out.println("Me fale o nome do cliente: ");
		String nome = sc.nextLine();

		System.out.println("Me fale o CPF do cliente: ");
		String cpf = sc.nextLine();

		System.out.println("Me fale a chave pix do cliente: ");
		String pix = sc.nextLine();

		System.out.println("Me fale o telefone do cliente: ");
		String telefone = sc.nextLine();

		sis.cadastrarUsuario(nome, cpf, pix, telefone);
	}

	public static void exibirSistema(Sistema sis){
		sis.mostraLista();
	}
}