public class Heap{
	private int[] heap;
	private int tail;
	
	public Heap(int capacidade){
		this.heap = new int[capacidade];
		this.tail = -1;
	}
	
	public boolean isEmpty(){
		return this.tail == -1;
	}
	
	public void add(int n){
		if(tail >= (heap.length - 1)) resize();
		
		this.tail += 1;
		this.heap[tail] = n;
		
		int i = tail;
		while(i > 0 && this.heap[parent(i)] < this.heap[i]){
			int aux = this.heap[i];
			this.heap[i] = this.heap[parent(i)];
			this.heap[parent(i)] = aux;
			i = parent(i);
		}
	}

	public int parent(int i){
		return ((i -1)/ 2);
	}
	
	public int remove(){
		if(isEmpty()) throw new RuntimeException("Empty");
		
		int element = this.heap[0];
		
		this.heap[0] = this.heap[tail];
		
		this.tail -= 1;
		
		this.heapify(0);
		
		return element;
	}
	
	public void heapify(int index){
		if(isLeaf(index) || !isValidIndex(index)) 
			throw new RuntimeException("Invalido");
		
		int indexMax = maxIndex(index, left(index), rigth(index));
		
		if(indexMax != index){
			swap(index, indexMax);
			heapify(indexMax);
		}
	}
	
	public int maxIndex(int index, int left, int rigth){
		if(this.heap[index] > this.heap[left]){
			if(isValidIndex(rigth)){
				if(this.heap[index] < this.heap[rigth])
					return rigth;
			}
			
			return index;
		}else{
			if(isValidIndex(rigth)){
				if(this.heap[left] < this.heap[rigth])
					return rigth;
			}
			
			return left;
		}
	}
	
	public boolean isValidIndex(int index){
		return index >= 0 && index <= tail;
	}
	
	public boolean isLeaf(int index){
		return index > parent(tail) && index <= tail;
	}
	
	public void swap(int i, int j){
		int aux = this.heap[i];
		this.heap[i] = this.heap[j];
		this.heap[j] = aux;
	}
	
	public int left(int i){
		return (2 * i) + 1;
	}
	
	public int rigth(int i){
		return (2 * 1) + 2;
	}
	
	private void resize(){
		int[] newHeap = new int[heap.length * 2];
		
		for(int i = 0; i < heap.length; i++) 
			newHeap[i] = this.heap[i];
		
		this.heap = newHeap;
	}
}

