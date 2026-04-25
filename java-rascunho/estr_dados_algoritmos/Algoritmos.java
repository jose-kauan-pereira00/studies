import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Algoritmos {

	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String linha = "";
		
			System.out.println("Algoritmo TamanhoEntrada TempoMedio");


			while((linha = reader.readLine()) != null){
				String[] array = linha.split(" ");

				/**
				 * Compara Os estremos, Função constante, pois so usa Primitivas
				 * */
				long tempoInicio = System.nanoTime();
				for(int i = 0; i < 300; i++){
					comparaExtremos(array);
				}
				long tempoFim = System.nanoTime();

				long tempoMedia = (tempoFim - tempoInicio) / 300;

				System.out.println("ComparaExtremos " + array.length + " " + tempoMedia);

				/**
				 * Busca Linear, cresce em forma de grafico Linear, pois depende Diretamente de N, 
				 * theta de N
				 * */

				tempoInicio = System.nanoTime();
				for(int i = 0; i < 300; i++){
					buscaLinear(array, "Nao_Existe");//para garantir o pior caso
				}
				tempoFim = System.nanoTime();
				
				tempoMedia = (tempoFim - tempoInicio) / 300;

				System.out.println("BuscaLinear " + array.length + " " + tempoMedia);
			}


		} catch (IOException e) {
			System.out.println("Sem entrada ou entrada invalida.");
		}
	}


	/**
	 * Algoritmos de Testes 
	 * */


	private static boolean comparaExtremos(String[] array){
		return array[0].equals(array[array.length - 1]);
	}

	private static int buscaLinear(String[] array,  String elemento){
		for(int i = 0; i < array.length; i++){
			if(array[i].equalsIgnoreCase(elemento)){
				return i;
			}
		}
		return -1;
	}

  private static int[] ordenaPrimeiro(String[] array){
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

    return arrayNumeros;
    }

}
