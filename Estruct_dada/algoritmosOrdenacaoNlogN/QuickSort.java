import java.util.Arrays;

public class QuickSort{
	public static void main(String[] args){

		int[] vetor = {4, 5, 6,1 , 8, 9, 10, 12,44, 43, 100, 102, 410, 120, 605, 106, 1023, 1003, 105, 100};

		int[] vetor1 = {-4 , -3 , -10, 100000,  -10000, 4, 5 , 5, 6,1 , 8, 9, 10, 12,44, 43, 100, 102, 410, 120, 605, 106, 1023, 1003, 105, 100};
		int[] vetor2 = {};
		int[] vetor3 = {4};
		int[] vetor4 = {1, 2, 3, 4, 5, 6, 7, 8, 9};


		quickSort(vetor, 0, vetor.length - 1);
		System.out.println(Arrays.toString(vetor));
		quickSort(vetor1, 0, vetor1.length -1);
		System.out.println(Arrays.toString(vetor1));
		quickSort(vetor2, 0, vetor2.length - 1);
		System.out.println(Arrays.toString(vetor2));
		quickSort(vetor3, 0, vetor3.length - 1);
		System.out.println(Arrays.toString(vetor3));
		quickSort(vetor4,0, vetor4.length -1);
		System.out.println(Arrays.toString(vetor4));
	}

	public static void quickSort(int[] v, int inicio, int fim){

    if(inicio < fim){
      int pivotIndex = particiona(v, inicio, fim);

      quickSort(v, inicio, pivotIndex - 1);
      quickSort(v, pivotIndex + 1, fim);
    }

	}

	public static int particiona(int[] v, int inicio,  int fim){
    int pivot = v[inicio];
    int i = inicio;

    for(int j = i + 1; j <= fim; j++)
      if(v[j] <= pivot){
        i++;
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
      }
    int aux = v[i];
    v[i]= v[inicio];
    v[inicio] = aux;

    return i;
	}
}
