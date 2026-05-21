import java.util.Arrays;

public class SelectionSort{
	public static void main(String[] args){
		int[] vetor = {4, 5, 6,1 , 8, 9, 10, 12,44, 43, 100, 102, 410, 120, 605, 106, 1023, 1003, 105, 100};

		int[] vetor1 = {-4 , -3 , -10, 100000,  -10000, 4, 5 , 5, 6,1 , 8, 9, 10, 12,44, 43, 100, 102, 410, 120, 605, 106, 1023, 1003, 105, 100};
		int[] vetor2 = {};
		int[] vetor3 = {4};
		int[] vetor4 = {1, 2, 3, 4, 5, 6, 7, 8, 9};


		selectionSort(vetor);
		System.out.println(Arrays.toString(vetor));
		selectionSort(vetor1);
		System.out.println(Arrays.toString(vetor1));
		selectionSort(vetor2);
		System.out.println(Arrays.toString(vetor2));
		selectionSort(vetor3);
		System.out.println(Arrays.toString(vetor3));
		selectionSort(vetor4);
		System.out.println(Arrays.toString(vetor4));
	}

	public static void selectionSort(int[] arr){
		for(int i = 0; i < arr.length; i++){

			int menorInd = i;

			for(int k = i + 1; k < arr.length; k++){
				if(arr[k] < arr[menorInd]) menorInd = k;
			}

			int auxiliar = arr[i];
			arr[i] = arr[menorInd];
			arr[menorInd] = auxiliar;

		}
	}
}
