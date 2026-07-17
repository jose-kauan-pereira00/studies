import java.util.Arrays;

public class MergeSort{
	public static void main(String[] args){

		int[] vetor = {4, 5, 6,1 , 8, 9, 10, 12,44, 43, 100, 102, 410, 120, 605, 106, 1023, 1003, 105, 100};

		int[] vetor1 = {-4 , -3 , -10, 100000,  -10000, 4, 5 , 5, 6,1 , 8, 9, 10, 12,44, 43, 100, 102, 410, 120, 605, 106, 1023, 1003, 105, 100};
		int[] vetor2 = {};
		int[] vetor3 = {4};
		int[] vetor4 = {1, 2, 3, 4, 5, 6, 7, 8, 9};


		mergeSort(vetor, 0, vetor.length - 1);
		System.out.println(Arrays.toString(vetor));
		mergeSort(vetor1, 0, vetor1.length -1);
		System.out.println(Arrays.toString(vetor1));
		mergeSort(vetor2, 0, vetor2.length - 1);
		System.out.println(Arrays.toString(vetor2));
		mergeSort(vetor3, 0, vetor3.length - 1);
		System.out.println(Arrays.toString(vetor3));
		mergeSort(vetor4,0, vetor4.length -1);
		System.out.println(Arrays.toString(vetor4));
	}

	public static void mergeSort(int[] vetor, int inicio, int fim){
		if(inicio < fim){

			int meio = (inicio + fim) / 2;

			mergeSort(vetor, inicio, meio);
			mergeSort(vetor, meio + 1, fim);
			merge(vetor, inicio, meio, fim);
		}
	}

	public static void merge(int[] vetor, int inicio, int meio, int fim){
		int[] vetorAuxiliar = new int[vetor.length];

		for(int i = inicio; i <= fim; i++) vetorAuxiliar[i] = vetor[i];

		int i = inicio;
		int j = meio + 1;
		int k = inicio;

		while(i <= meio && j <= fim){
			if(vetorAuxiliar[i] <= vetorAuxiliar[j]){
				vetor[k++] = vetorAuxiliar[i++];
			}else{
				vetor[k++] = vetorAuxiliar[j++];
			}
		}

		while(i <= meio) vetor[k++] = vetorAuxiliar[i++];
		while(j <= fim) vetor[k++] = vetorAuxiliar[j++];
	}
}
