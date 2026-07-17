public class LinkedList{
  int size;
  Node head;
  Node tail;

  public LinkedList(){ 
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  public void removeFirst(){
    if(isEmpty()) throw new RuntimeException("Sem elementos");

    if(this.size == 1){
      System.out.println("Ultimo elemento: " + tail.value);
      this.head = null;
      this.tail = null;
    }else{
      this.head = head.next;
      head.prev = null;
    }
    this.size--;
  }

  public void removeLast(){
    if(isEmpty()) throw new RuntimeException("Sem Elementos");

    if(this.size == 1){
      System.out.println("Único Elemento Removido: " + head.value);
      this.head = null;
      this.tail = null;
    }else{
      this.tail = tail.prev;
      tail.next = null;
    }
    this.size--;
  }

  public void addLast(Integer value){
    Node novoNo = new Node(value);

    if(isEmpty()){
      this.head = novoNo;
      this.tail = novoNo;
    }else{
      this.tail.next = novoNo;
      novoNo.prev = tail;
      this.tail = novoNo;
    }
    this.size++;
  }

  public void addFirst(Integer value){
    Node novoNo = new Node(value);

    if(isEmpty()){
      this.head = novoNo;
      this.tail = novoNo;
    }else{
      this.head.prev = novoNo;
      novoNo.next = head;
      this.head = novoNo;
    }
    this.size++;
  }

  public void string(){
    Node aux = head;

    while (aux != null) {
      System.out.println(aux.value);
      aux = aux.next;
    }
  }

  public boolean isEmpty(){
    return this.size == 0;
  }
}

class Node{
  Integer value;
  Node prev;
  Node next;

  Node(Integer value){
    this.value = value;
  }
}
