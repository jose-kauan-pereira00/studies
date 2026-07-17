package animais;

import java.util.HashMap;
import java.util.Map;

public class SistController {
	private int indice;
	private Map<Integer , Animal> animais;

	public SistController(){
		this.indice = 0;
		this.animais = new HashMap<>();
	}

	public boolean criarCachorro(String nome, String cor, int idade, String raca){
		Animal animal = new Cachorro(nome, cor, idade, raca);
		animais.put(indice, animal);
		return true; 
	}

	public boolean criarGato(String nome, String cor, int idade, String racaG){
		Animal animal = new Gato(nome, cor, idade, racaG);
		animais.put(indice, animal);
		return true;
	}

	public boolean criarPassaro(String nome, String cor, int idade){
		Animal animal = new Passaro(nome, cor, idade);
		animais.put(indice, animal);
		return true;
	}

	public Animal getAnimal(int indide){
		return animais.get(indice);
	}

	private boolean adicionarAnimal(int id, Animal animal){
		animais.put(id, animal);
	}

}