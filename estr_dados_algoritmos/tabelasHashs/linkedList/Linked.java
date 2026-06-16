public class Linked{
  private Node head, tail;

  public Linked(){
    this.head = null;
    this.tail = null;
  }

  public boolean isEmpty(){
    return this.head == null && this.tail == null;
  }

  public void addLast(int value){
    Node newNode = new Node(value);

    if(isEmpty()){
      this.head = newNode;
      this.tail = newNode;
    } else{
      tail.next = newNode;
      tail = tail.next;
    }
  }

  public void addFist(int value){
    Node newNode =  new Node(value);

    if(isEmpty()){
      this.head = newNode;
      this.tail =newNode;
    } else{
      newNode.next = head;
      this.head = newNode;
    }
  }

  public boolean contains(int v){
    if(isEmpty()) return false;

    Node aux = head;

    while (aux != null) {
      if(aux.value == v) return true;
      aux = aux.next;
    }
    return false;
  }

  public int indexOf(int v){
    if(isEmpty()) return -1;

    Node aux = head;

    int contador = 0;

    while (aux != null) {
      if(aux.value == v) return contador;
      aux = aux.next;
      contador++;
    }

    return -1;

  }
}

class Node{

  int value;
  Node next;
  Node prev;

  Node(int v){

    this.value = v;
    this.next = null;
    this.prev = null;

  }
}
