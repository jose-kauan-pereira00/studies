import java.util.Arrays;
public class MergeSort{
	public static void main(String[] args){
		int[] v = {4, 1, 2, 8, 20, 10, 5, 9, 7, 3, 90, 50, 47, 82, 102};

		mergeSort(v, 0, v.length - 1);

	}

	public static void mergeSort(int[] vetor, int ini, int fim){
		if(ini < fim){
			int meio = (ini + fim)/2;
			mergeSort(vetor, ini, meio);
			mergeSort(vetor, meio + 1, fim);
			merge(vetor, ini, meio, fim);
		}
	}

	public static void merge(int[] vetor, int ini, int meio, int fim){
		int[] arrayEsquerda = new int[meio - ini];
		for(int i = 0; i <= meio; i++) arrayEsquerda[i] = vetor[i];
		System.out.println(Arrays.toString(arrayEsquerda));

		int[] arrayDireita = new int[fim - meio];
		for(int i = meio + 1; i <= fim; i++) arrayDireita[i] = vetor[i];
		System.out.println(Arrays.toString(arrayDireita));
	}
}

