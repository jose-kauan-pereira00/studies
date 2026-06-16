public class Fila{
  private int[] fila;
  private int size;
  private int head;
  private int tail;

  public Fila(int capacidade) {
    this.fila =  new int[capacidade];
    size = 0;
    head = -1;
    tail = -1;
  }

  public void shiftLeft(int indice){
    for(int i = indice; i < this.tail; i++) this.fila[i] = fila[i + 1];
  }

  public void addLast(int elem){
    if(!isFull()) this.size++;

    if (isEmpty()) this.head = 0;

    if(isFull()){ 
      head = (this.head + 1) % this.fila.length;
    }

    this.tail = (tail + 1) % this.fila.length;
    this.fila[tail] = elem;
  }

  private int removeFirst(){
    if(isEmpty()) throw new RuntimeException("this.fila Vazia");
    int value = this.fila[head];

    if (head == tail) {
      head = -1;
      tail = -1;
    }else{
      head = (head + 1) % fila.length;
    }
    size--;
    
    return value;
  }
  
  public boolean isFull(){
    return size >= this.fila.length;
  }

  public boolean isEmpty(){
    return size == 0;
  }

}
