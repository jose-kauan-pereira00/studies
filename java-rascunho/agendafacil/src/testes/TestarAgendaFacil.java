package testes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import agendafacil.AgendaFacil;

public class TestarAgendaFacil{
	private AgendaFacil sistema;

  @BeforeEach
  void setUp(){
    sistema = new AgendaFacil();
    sistema.cadastrarEstudante("Alice", "alice@email.com");
    sistema.cadastrarEstudante("Bob", "bob@email.com");
    sistema.cadastrarEstudante("Kauan", "kauan@gmail");
    sistema.cadastrarEstudante("jose", "jose@gmail");
  }

  @Test
  void testCalculoPontuacao() {
        // Workshop de 5 horas = 5 pontos
        int idW = sistema.cadastrarWorkshop("Java Avançado", "Desc", "10/10", 10, 5);
        // Palestra = 2 pontos
        int idP = sistema.cadastrarPalestra("IA no Futuro", "Desc", "11/10", 10);

        sistema.inscreverParticipanteEmEvento("alice@email.com", idW); // Alice: 5
        sistema.inscreverParticipanteEmEvento("alice@email.com", idP); // Alice: 5 + 2 = 7
        
        sistema.inscreverParticipanteEmEvento("bob@email.com", idP); // Bob: 2

        assertEquals("Alice; Eventos: 2; Pontos: 7", sistema.exibirEstudante("alice@email.com"));
        assertEquals("Bob; Eventos: 1; Pontos: 2", sistema.exibirEstudante("bob@email.com"));
    }
  @Test
    void testExcecaoVagasEsgotadas() {
        int id = sistema.cadastrarPalestra("Limitada", "Desc", "14/10", 1);
        sistema.inscreverParticipanteEmEvento("alice@email.com", id);
        
        // Deve falhar pois só tem 1 vaga
        assertThrows(IllegalArgumentException.class, () -> {
            sistema.inscreverParticipanteEmEvento("bob@email.com", id);
        });
    }
}
