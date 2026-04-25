package agendafacil;

public class Workshop extends Evento{
  
  private int duracao;

  public Workshop(String titulo, String descricao, String data,  int quantidadaMax, int duracao){
    super(titulo, descricao, data, quantidadaMax);
    this.duracao = duracao;
  }

  @Override
  protected String exibirDetalhes(){
    return super.titulo + ", " + super.descricao + ", " + super.data + this.calcularPontuacao() + super.participantes;
  }

  @Override
  protected int calcularPontuacao(){
    return this.duracao;
  }
}
