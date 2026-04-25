import java.util.Scanner;
import java.util.Arrays;

class OrdenaPrimeiro{

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String[] array = sc.nextLine().split(" ");

		sc.close();

		boolean ordenado = false;

		int[] arrayNumeros = new int[array.length];

		for(int i = 0; i < array.length;i++){
		   arrayNumeros[i] = Integer.parseInt(array[i].trim());
		}

		int indice = 0;

		while (ordenado) {

			if(arrayNumeros[indice] > arrayNumeros[indice + 1]){
		      int auxiliar = arrayNumeros[indice];
		      arrayNumeros[indice] = arrayNumeros[indice + 1];
		      arrayNumeros[indice + 1] = auxiliar;
		      indice++;

		      }else{ ordenado =  true; }
		    }

		  System.out.println(Arrays.toString(arrayNumeros));
		  }
}