public class Pilha{

  private int topo;
  private int[] pilha;

  public Pilha(int capacidade){
    this.topo =  -1;
    this.pilha = new int[capacidade];
  }

  public void push(int valor){
    if(isFull()) throw new RuntimeException("Pilha Cheia");

    pilha[++topo] = valor;
  }

  public int peek(){
    if(isEmpty()) throw new RuntimeException("Pilha Vazia");

    return pilha[topo];
  }

  public int pop(){
    if(isEmpty()) throw new RuntimeException("Pilha Vazia");

    return pilha[topo--];
  }

  public boolean isEmpty(){
    return topo == -1;
  }

  public boolean isFull(){
    return topo == pilha.length -1;
  }
}
