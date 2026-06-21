import java.util.ArrayList;

public class TabelaHash{

  private Aluno[] tabela;
  public static final int CAPACIDADE = 20;

  public TabelaHash(int capacidade){
    this.tabela = new Aluno[capacidade];
  }

  public TabelaHash(){
    this(CAPACIDADE);
  }

  public int hash(int mat){
    return mat % this.tabela.length;
  }

  public void put(int chave, Aluno valor){
    this.tabela[hash(chave)] = valor;

  }

  public Aluno get(int chave){
    return this.tabela[hash(chave)];
  }

  public void remove(int chave){
    this.tabela[hash(chave)] = null;
  }
}
