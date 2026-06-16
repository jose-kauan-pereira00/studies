public class Main{
  public static void main(String[] args){
    Pilha pilha = new Pilha(5);

    pilha.push(8);
    pilha.push(9);
    pilha.push(19);
    pilha.push(4);
    pilha.push(1);

    System.out.println(pilha.isFull());
    System.out.println(pilha.isEmpty());

    pilha.pop();
    pilha.pop();
    pilha.pop();
    pilha.pop();
    pilha.pop();
    System.out.println(pilha.isEmpty());
    pilha.pop();
  }
}
