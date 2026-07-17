package animais;

public class Passaro extends Animal{

	public Passaro(String nome, String cor, int idade) {
		super(nome, cor, idade);
	}

	public void cantar(){
		System.out.println("Cantando...");
	}

	@Override
	public void respirar() {
		System.out.println("Respirando...");
	}

	@Override
	public void fazezSom() {
		System.out.println("Piu piu");
	}

	
}