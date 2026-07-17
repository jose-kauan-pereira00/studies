package agendafacil;

import java.util.*;

public abstract class Evento{
  protected String titulo;
  protected String descricao;
  protected String data;
  protected int qntMaxParicipantes;
  protected int pontuacao;
  protected Map<String,Usuario> participantes;

  public Evento(String titulo, String descricao, String data, int qntMaxParicipantes){
    this.titulo = titulo;
    this.descricao = descricao;
    this.data = data;
    this.qntMaxParicipantes = qntMaxParicipantes;
    this.participantes = new HashMap<>();
  }
  
  protected abstract String exibirDetalhes();
  protected abstract int calcularPontuacao();

  public boolean cadastrarParticipante(String email, Usuario u){
   if (participantes.containsKey(email)) {
        throw new IllegalArgumentException("Participante já inscrito neste evento.");
    }
    if (participantes.size() >= qntMaxParicipantes) {
        throw new IllegalArgumentException("Evento atingiu a capacidade máxima.");
    }
    participantes.put(email, u);
    return true;
  }

}
