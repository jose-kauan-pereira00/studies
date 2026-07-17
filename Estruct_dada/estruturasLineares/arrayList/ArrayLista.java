public class ArrayLista{
  private Integer[] lista;
  private int capacidade = 20;
  private int tamanho;

  public ArrayLista(){
    this.tamanho = 0;
  }

  public ArrayLista(int capacidade){
    this.lista = new Integer[capacidade];
    this.tamanho = 0;
  }

  public boolean add(Integer value){
    if(isFull()) risize();

    lista[tamanho++] = value;

    return true;
  }

  public void add(int indice, Integer value){
    if(indice > tamanho || indice < 0) throw new IllegalArgumentException("Indice Invalido");

    if(indice == this.tamanho) add(value);

    if(this.tamanho == lista.length) risize();
    
    shiftRight(indice);

    this.lista[indice] = value;
  }

  public void set(int indice, Integer value){
    if(indice > tamanho || indice < 0) throw new IllegalArgumentException("Indice Invalido");

    lista[indice] = value;
  }



  private boolean isFull(){
    return this.tamanho == this.lista.length;
  }

  private void shiftRight(int indice){
    if(isFull()) risize();
    for(int i = this.tamanho; i > indice; i--) lista[i] = lista[i - 1];
  }

  private void risize(){
    Integer[] novaLista = new Integer[lista.length*2];

    for(int i = 0; i < this.lista.length; i++) novaLista[i] = lista[i];

    this.lista = novaLista;
  }
}
