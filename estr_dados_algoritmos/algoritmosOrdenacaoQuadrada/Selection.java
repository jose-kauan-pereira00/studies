import java.util.Arrays;
public class Selection{
	public static void main(String[] args){

		int[] vetor = {4, 5, 6,1 , 8, 9, 10, 12,44, 43, 100, 102, 410, 120, 605, 106, 1023, 1003, 105, 100};

		int[] vetor1 = {-4 , -3 , -10, 100000,  -10000, 4, 5 , 5, 6,1 , 8, 9, 10, 12,44, 43, 100, 102, 410, 120, 605, 106, 1023, 1003, 105, 100};
		int[] vetor2 = {};
		int[] vetor3 = {4};
		int[] vetor4 = {1, 2, 3, 4, 5, 6, 7, 8, 9};


		selection(vetor);
		System.out.println(Arrays.toString(vetor));
		selection(vetor1);
		System.out.println(Arrays.toString(vetor1));
		selection(vetor2);
		System.out.println(Arrays.toString(vetor2));
		selection(vetor3);
		System.out.println(Arrays.toString(vetor3));
		selection(vetor4);
		System.out.println(Arrays.toString(vetor4));
	}

	public static void selection(int[] array){
		for(int i = 0; i < array.length; i++){

			int indiceDoMenor = i;

			for(int k = i + 1; k < array.length;k++){
				if(array[k] < array[indiceDoMenor]) indiceDoMenor = k;
			}

			int auxiliar = array[i];
			array[i] = array[indiceDoMenor];
			array[indiceDoMenor] = auxiliar;
		}
	}
}
