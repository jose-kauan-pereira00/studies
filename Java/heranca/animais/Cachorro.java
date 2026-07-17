package animais;

public class Cachorro extends Animal{
	private String raca;


	public Cachorro(String nome, String cor, int idade, String raca) {
		super(nome, cor, idade);
		this.raca = raca;

	}
	public void seCocar(){
		System.out.println("Se Coçando....");
	}

	@Override
	public void respirar() {
		System.out.println("Respirando Ofegante");
	}

	@Override
	public void fazezSom() {
		System.out.println("Au au au");
	}

	
}