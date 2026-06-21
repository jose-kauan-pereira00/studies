public class Testes{

  public static void main(String[] args){
    LinkedList lista = new LinkedList();

    lista.addLast(89);
    lista.addLast(78);
    lista.addFirst(690);
    lista.addFirst(7529);

    lista.string();
    System.out.println("Remoções");
    lista.removeLast();
    lista.removeLast();
    lista.string();
    lista.removeLast();
    lista.removeLast();


    lista.addLast(1);
    lista.addLast(2);
    lista.addLast(3);
    lista.addLast(4);
    lista.addLast(5);
    lista.addLast(6);
    lista.addLast(7);
    lista.addLast(8);

    lista.string();

    System.out.println("Remoções do primeiro");

    lista.removeFirst();
    
    lista.removeFirst();
    lista.removeFirst();
    lista.removeFirst();
    lista.string();

  }
}
