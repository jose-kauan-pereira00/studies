package agendafacil;

import java.util.*;

public class AgendaFacil{ 
  
  private int idEvento;
  private Map<String, Usuario> usuarios;
  private Map<Integer, Evento> eventos;

  public AgendaFacil(){

    this.idEvento = 0;
    this.usuarios = new HashMap<>();
    this.eventos = new HashMap<>();

  }

  public boolean cadastrarEstudante(String nome, String email){
    if(usuarios.containsKey(email)){
      throw new IllegalArgumentException("Email ja cadastrado no Sistema:(");
      }
    Usuario u = new Usuario(nome, email);
    usuarios.put(email, u);
    return true;
  }

  public String exibirEstudante(String email){
    return usuarios.get(email).exibirInf();
  }

  public String[] listarEstudantes(){
    List<Usuario> lista = new ArrayList<>(usuarios.values());

    Collections.sort(lista, (u1, u2) -> Integer.compare(u2.getTotalPontos(), u1.getTotalPontos()));

    String[] resultado = new String[lista.size()];
    for (int i = 0; i < lista.size(); i++) {
        resultado[i] = lista.get(i).getNome() + " - " + lista.get(i).getTotalPontos() + " pontos";
    }
    return resultado;
  }

  public int cadastrarPalestra(String titulo, String descricao, String data, int maxParticipantes){
    Evento e = new Palestra(titulo, descricao, data, maxParticipantes);
    eventos.put(idEvento, e);
    idEvento++;
    return idEvento -1;
  }

  public int cadastrarWorkshop(String titulo, String descricao, String data, int maxParticipantes, int duracao){
    Evento e = new Workshop(titulo, descricao, data, maxParticipantes, duracao);
    eventos.put(idEvento, e);
    idEvento++;
    return idEvento -1;
  }

  public int cadastrarOficinaAprendizagem(String titulo, String descricao, String data, int maxParticipantes, int duracao, boolean certificacao){
    Evento e = new OficinaAprendizagem(titulo, descricao, data, maxParticipantes, duracao, certificacao);
    eventos.put(idEvento,e);
    idEvento++;
    return idEvento -1;
  }

  public boolean inscreverParticipanteEmEvento(String emailParticipante, int idEvento){
    var u = usuarios.get(emailParticipante);
    var e = eventos.get(idEvento);
    
    u.participarEvento(idEvento, e);
    return e.cadastrarParticipante(emailParticipante, u);
  }

  public String exibirDetalhesEvento(int idEvento){
    return eventos.get(idEvento).exibirDetalhes();
  }

}
