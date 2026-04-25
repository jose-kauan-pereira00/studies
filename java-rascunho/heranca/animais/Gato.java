package animais;

public class Gato extends Animal{

	private String racaG;

	public Gato(String nome, String cor, int idade, String racaG) {
		super(nome, cor, idade);
		this.racaG = racaG;
	}

	public void pular(){
		System.out.println("Pulando...");
	}

	@Override
	public void respirar() {
		System.out.println("Respirando Tranquilo...");
	}

	@Override
	public void fazezSom() {
		System.out.println("Miau miau");
	}


}