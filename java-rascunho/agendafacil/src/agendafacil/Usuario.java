package agendafacil;

import java.util.*;

public class Usuario implements Comparable<Usuario>{
    private String nome;
    private String email;
    private int pontos;
    private Map<Integer, Evento> eventosParticipados;

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.eventosParticipados = new HashMap<>();
        this.pontos = 0;
    }

    public int getTotalPontos() {
        int total = 0;
        for (Evento e : eventosParticipados.values()) {
            total += e.calcularPontuacao();
        }
        if(total != pontos){
          pontos = total;
        }
        return total;
    }

    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public int getQuantidadeEventos() { return eventosParticipados.size(); }

    public void participarEvento(int id, Evento e) {
        eventosParticipados.put(id, e);
    }

    public String exibirInf() {
        return String.format("%s; Eventos: %d; Pontos: %d", 
                nome, getQuantidadeEventos(), getTotalPontos());
    }

    @Override
    public int comparaTo(Usuario outro){
      return Integer.compare(outro.getTotalPontos(), this.getTotalPontos());
      //em ordem crescente seria (this.getTotalPontos(), outro.getTotalPontos());
    }
}
