public class BST0{

	private No raiz;

	public BST0(){
		raiz = null;
	}

	public boolean isVazio(){
		return raiz == null;
	}

	public void add(int v){
		No novoNo = new No(v);
		if(isVazio()) raiz = novoNo;
		else{
			No aux = raiz;

			while(aux != null){
				if(v < aux.valor){
					if(aux.esquerda == null){
						aux.esquerda = novoNo;
						return;
					}
					aux = aux.esquerda;
				}else{
					if(aux.direita == null){
						aux.direita = novoNo;
						return;
					}
					aux = aux.direita;
				}
			}
		}
	}

	public boolean isFolha(No no){
		return no.direita == null && no.esquerda == null;
	}

	public int contaMenores(int v){
		return contaMenores(this.raiz, v);
	}

	private int contaMenores(No no, int v){
		if(no == null) return 0;

		if(no.valor < v) return 1 + contaMenores(no.esquerda, v) + contaMenores(no.direita, v);
		else return contaMenores(no.esquerda, v);
	}

	public int contaMaiores(int v){
		return contaMaiores(this.raiz, v);
	}

	public int contaMaiores(No no, int v){
		if(no == null) return 0;

		if(no.valor > v) return 1 + contaMaiores(no.esquerda, v) + contaMaiores(no.direita, v);
		else return contaMaiores(no.direita, v);

	}

	public No max(){
		return max(this.raiz);
	}

	public No min(){
		return min(this.raiz);
	}

	public No min(No atual){
		if(atual.esquerda == null) return atual;
		else return min(atual.esquerda);
	}


	public No max(No atual){
		if(atual.direita == null) return atual;
		else return max(atual.direita);
	}

}

class No{
	int valor;
	No pai;
	No esquerda;
	No direita;

	public No(int v){
		this.valor = v;
	}
}