public class HeapMin{

	private int[] heap;
	private int tail;

	public HeapMin(int v){
		heap = new int[v];
		tail = -1;
	}

	public HeapMin builHeapMin(int[] array){
		HeapMin novoHeap = new HeapMin(array.length);

		for(int i = 0; i < array.length; i++){
			novoHeap.add(array[i]);
		}

		return novoHeap;
	}


	public boolean isLeaf(int index){
		return index > parent(tail) && index <= tail;
	}

	public boolean isValidIndex(int index){
		return index >= 0 && index <= tail;
	}

	public void heapify(int index){
		if(isLeaf(index) || !isValidIndex(index)) return;

		int indexMenor = indexMin(index, left(index), right(index));

		if(indexMenor != index){
			int aux = heap[index];
			heap[index] = heap[indexMenor];
			heap[indexMenor] = aux;
			heapify(indexMenor);
		}

	}

	public void add(int v){

		tail += 1;

		heap[tail] = v;

		int i = tail;

		while(i > 0 && heap[i] < heap[parent(i)]){
			int aux =  heap[i];
			heap[i] = heap[parent(i)];
			heap[parent(i)] = aux;

			i = parent(i);
		}

	}

	public void paraString(){
		for(int i = 0; i <= tail; i++){
			System.out.print(heap[i] + " ");
		}
		System.out.println();
	}

	public int indexMin(int index, int left, int right){
		if(heap[index] < heap[left]){
			if(isValidIndex(right)){
				if(heap[right] < heap[index]) return right;
			}
			return index;
		}else{
			if(isValidIndex(right)){
				if(heap[right] < heap[left]) return right;
			}
			return left;
		}
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