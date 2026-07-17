package  agendafacil;

public class OficinaAprendizagem extends Evento{

  private int duracao;
  private boolean certificado;

  public OficinaAprendizagem(String titulo, String descricao, String data, int duracao, int quantidadeMaxima , boolean certificado){
    super(titulo, descricao, data, quantidadeMaxima);
    this.certificado = certificado;
    this.duracao = duracao;
    }
  
  @Override
  protected String exibirDetalhes(){
    return super.titulo + ", " + super.descricao + ", " + super.data + this.calcularPontuacao() + super.participantes;
  }

  @Override
  protected int calcularPontuacao(){
    if(certificado) return this.duracao + 10;

    return this.duracao;
  }
}
