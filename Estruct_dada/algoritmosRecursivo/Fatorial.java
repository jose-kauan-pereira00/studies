import java.util.Scanner;

public class Fatorial{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.println("Me passe um Número Inteiro: ");
		int n = sc.nextInt();
		System.out.println(fatorial(n));
	}

	public static int fatorial(int n){
		if(n == 0 || n == 1) return 1;
		return n * fatorial(n - 1);

	}	
}
