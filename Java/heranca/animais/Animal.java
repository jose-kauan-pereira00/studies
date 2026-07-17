package animais;

public abstract class Animal{
	private String nome;
	private String cor;
	protected int idade;

	public Animal(String nome, String cor, int idade){
		this.nome = nome;
		this.cor = cor;
		this.idade = idade;
	}

	public abstract void respirar();

	public abstract void fazezSom();

	public String mover(){
		System.out.println("Se Movimentantando....");
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
}