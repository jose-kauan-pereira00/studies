public class Heap02{
	private int[] heap;
	private int tail;

	public Heap02(int capacidade){
		this.heap = new int[capacidade];
		this.tail = -1;
	}

	public boolean isVazio(){
		return tail == -1;
	}

	public void add(int v){
		if(tail == heap.length -1) resize();


		heap[++tail] = v;

		int i = tail;

		while(i > 0 && heap[i] > heap[pai(i)]){
			int aux = heap[i];
			heap[i] = heap[pai(i)];
			heap[pai(i)] = aux;

			i = pai(i);
		}
	}

	private void resize(){
		int[] novo = new int[heap.length * 2];

		for(int i = 0; i < heap.length; i++) novo[i] = heap[i];

		heap = novo;
	}

	public int pai(int i){
		return (int)(i - 1) / 2;
	}

	public int esquerda(int i){
		return (2 * i + 1);
	}

	public int direita(int i){
		return 2 * i + 2;
	}
}