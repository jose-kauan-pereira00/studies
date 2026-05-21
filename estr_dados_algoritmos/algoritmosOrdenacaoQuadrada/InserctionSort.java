import java.util.Arrays;

public class InserctionSort{
	public static void main(String[] args){

		int[] vetor = {4, 5, 6,1 , 8, 9, 10, 12,44, 43, 100, 102, 410, 120, 605, 106, 1023, 1003, 105, 100};

		int[] vetor1 = {-4 , -3 , -10, 100000,  -10000, 4, 5 , 5, 6,1 , 8, 9, 10, 12,44, 43, 100, 102, 410, 120, 605, 106, 1023, 1003, 105, 100};
		int[] vetor2 = {};
		int[] vetor3 = {4};
		int[] vetor4 = {1, 2, 3, 4, 5, 6, 7, 8, 9};


		inserctionSort(vetor);
		System.out.println(Arrays.toString(vetor));
		inserctionSort(vetor1);
		System.out.println(Arrays.toString(vetor1));
		inserctionSort(vetor2);
		System.out.println(Arrays.toString(vetor2));
		inserctionSort(vetor3);
		System.out.println(Arrays.toString(vetor3));
		inserctionSort(vetor4);
		System.out.println(Arrays.toString(vetor4));
	
	}

	public static void inserctionSort(int[] vetor){
		for(int i = 1; i < vetor.length; i++){
			int j = i;

			while(j > 0 && vetor[j] < vetor[j - 1]){
				int aux = vetor[j - 1];
				vetor[j -1] = vetor[j];
				vetor[j] = aux;
				j--;
			}
		}
	}


}
