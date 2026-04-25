package agendafacil;

public class Palestra extends Evento{

  public Palestra(String titulo, String descricao, String data, int qntMaxima) {
    super(titulo, descricao, data, qntMaxima);
  }
  
  @Override
  protected String exibirDetalhes(){
    return super.titulo + ", " + super.descricao + ", " + super.data + this.calcularPontuacao() + super.participantes;
  }

  @Override
  protected int calcularPontuacao(){
    return 2;
  }
}
