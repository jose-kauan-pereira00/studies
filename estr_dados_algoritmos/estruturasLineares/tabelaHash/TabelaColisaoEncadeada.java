import java.util.ArrayList;

public class TabelaColisaoEncadeada{

  private ArrayList<Aluno> tabela;
  public static final int CAPACIDADE_DEFAULT = 20;
  private int capacidade;

  public TabelaColisaoEncadeada(int capacidade){
    this.tabela = new ArrayList<ArrayList<Aluno>>(capacidade);

    for(int i = 0; i < capacidade; i++)
      this.tabela.add(i, null);

    this.capacidade = capacidade;
  }

  public TabelaColisaoEncadeada(){
    this(CAPACIDADE_DEFAULT);
  }

  public int hash(int mat){
    return mat % this.capacidade;
  }

  public void put(int chave, Aluno valor){
    int hash = hash(chave);

    ArrayList<Aluno> alunos = this.tabela.get(hash);

    if(alunos == null){
      alunos = new ArrayList<Aluno>();
      alunos.add(valor);
      this.tabela.add(hash, alunos);
    }else{

      for(int i = 0; i < alunos.size(); i++){

        if(alunos.get(i).getMatricula() == chave){
          alunos.add(i, valor);
          return;
        }
      }
    }
    
    alunos.add(valor);

  }

  public Aluno get(int chave){
    int hash = hash(chave);

    ArrayList<Aluno> alunos = this.tabela.get(hash);

    if(alunos == null) return null;

    for(Aluno aux : alunos)
      if(aux.getMatricula() == chave) return aux;

    return null;
  }

  public void remove(int chave){
//    this.tabela[hash(chave)] = null;
  }
}
