public class heap01{
	private int[] heap;
	private int tail;

	public heap01(int capacidade){
		this.heap = new int[capacidade];
		this.tail = -1;
	}

	public boolean isEmpty(){
		return this.tail == -1;
	}

	public int remove(){
		if(isEmpty()) throw new RuntimeException("Vazia.");

		int elemento = heap[0];
		heap[0] = heap[tail];
		tail -= 1;

		heapify(0);

		return elemento;
	}

	public void paraTexto(){
		for(int i = 0; i <= tail; i++){
			System.out.print(heap[i] + " " + "Indice: " + i + " | ");
		}
		System.out.println();
	}

	public void heapify(int index){
		if(isLeaf(index) || !isValidIndex(index)) return;

		int indexMaior = indexMax(index, left(index), right(index));

		if(indexMaior != index){
			int aux = heap[index];
			heap[index] = heap[indexMaior];
			heap[indexMaior] = aux;
			heapify(indexMaior);
		}


	}

	public boolean isLeaf(int index){
		return index > parent(tail) && index <= tail;
	}

	public boolean isValidIndex(int index){
		return index >= 0 && index <= tail;
	}

	public int indexMax(int index, int left, int right){
		if(heap[index] > heap[left]){
			if(isValidIndex(right)){
				if(heap[index] < heap[right]) return right;
			}
			return index;
		}else{
			if(isValidIndex(right)){
				if(heap[left] < heap[right]) return right;
			}
			return left;
		}
	}

	public void add(int v){
		if(tail == heap.length -1) resize();

		tail += 1;

		heap[tail] = v;

		int i = tail;

		while(i > 0 && heap[parent(i)] < heap[i]){
			int aux = heap[parent(i)];
			heap[parent(i)] = heap[i];
			heap[i] = aux;

			i = parent(i);
		}
	}

	public void resize(){
		int[] novo = new int[heap.length * 2];

		for (int i = 0; i < heap.length; i++ ) novo[i] = heap[i];

		heap = novo;
	}

	public int parent(int index){
		return (int)((index -1) / 2);
	}

	public int left(int index){
		return (int)(2 * index + 1);
	}

	public int right(int index){
		return (int)(2 * index + 2);
	}


}