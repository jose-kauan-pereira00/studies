public class Bst01{
	private Node01 root;

	public boolean isEmpty(){
		return this.root == null;
	}

	public void add(int v){
		Node01 newNode = new Node01(v);
		if(isEmpty()){
			this.root = newNode;
		}else{

			Node01 aux = this.root;
			while(aux != null){
				if(v < aux.value){
					if(aux.left ==  null){
						aux.left = newNode;
						return;
					}
					aux = aux.left;
				}else{
					if(aux.rigth == null){
						aux.rigth = newNode;
						return;
					}
					aux = aux.rigth;
				}
			}
		}
	}

	public void addRecursive(int v){
		if(isEmpty()) this.root = new Node01(v);
		else addRecursive(this.root, v);
	}

	private void addRecursive(Node01 current, int v){
		if(v < current.value){
			if(current.left == null){
				Node01 novoNo = new Node01(v);
				current.left = novoNo;
				return;
			}
			addRecursive(current.left, v);
		}else{
			if(current.rigth == null){
				Node01 novoNo = new Node01(v);
				current.rigth = novoNo;
				return;
			}
			addRecursive(current.rigth, v);
		}
	}

	public Node01 search(int v){
		Node01 aux = this.root;

		while(aux != null){
			if(aux.value == v) return aux;
			else if(v < aux.value) aux = aux.left;
			else aux = aux.rigth;
		}

		return null;
	}

	public Node01 searchRecursive(int v){
		if(isEmpty()) return null;

		else return searchRecursive(this.root, v);
	}

	private Node01 searchRecursive(Node01 current, int v){
		if(current == null) return null;
		if(current.value == v)return current;
		else if(v < current.value) return searchRecursive(current.left, v);
		else return searchRecursive(current.rigth, v);
	}

	public Node01 max(){
		if(isEmpty()) throw new RuntimeException("vazia");
		else return max(this.root);
	}

	private Node01 max(Node01 current){
		if(current.rigth == null) return current;
		else return max(current.rigth);
	}


	public Node01 min(){
		if(isEmpty()) throw new RuntimeException("vazia");
		else return min(this.root);
	}

	private Node01 min(Node01 current){
		if(current.left == null) return current;
		else return min(current.left);
	}

	public Node01 sucessor(Node01 node){
		if(node == null) return null;

		if(node.rigth != null){
			return min(node.rigth);
		}else{
			Node01 aux = node.parent;

			while(aux != null && aux.value < node.value)
				aux = aux.parent;

			return aux;
		}
	}

	public Node01 predecessor(Node01 node){
		if(node == null) return null;

		if(node.left != null) return max(node.left);
		else{
			Node01 aux = node.parent;

			while(aux != null && aux.value > node.value)
				aux = aux.parent;

			return aux;
		}
	}

	public int altura(){
		return altura(this.root);
	}

	private int altura(Node01 current){
		if(current == null) return -1;
		else return 1 + Math.max(altura(current.left), altura(current.rigth));
	}

	public void remove(){

	}

	public void preOrder(){
		preOrder(this.root);
	}

	private void preOrder(Node01 current){
		if(current != null){
			System.out.println(current.value);
			preOrder(current.left);
			preOrder(current.rigth);
		}
	}

	public void inOrder(){
		inOrder(this.root);
	}

	private void inOrder(Node01 current){
		if(current != null){
			inOrder(current.left);
			System.out.println(current.value);
			inOrder(current.rigth);
		}
	}

	public int contaMaiores(int v){
		return contaMaiores(this.root, v);
	}

	private int contaMaiores(Node01 no,  int value){
		if(no == null) return 0;

		if(no.value > value) return 1 + contaMaiores(no.left, value) + contaMaiores(no.rigth, value);
		else return contaMaiores(no.rigth, value);

	}

	public int contaMenores(int v){
		return contaMenores(this.root, v);
	}

	public int contaMenores(Node01 no, int value){
		if(no == null) return 0;

		if(no.value < value) return 1 + contaMenores(no.left, value) + contaMaiores(no.rigth, value);
		else return contaMenores(no.left, value);

	}

	public void posOrder(){
		posOrder(this.root);
	}



	private void posOrder(Node01 current){
		if(current != null){
			posOrder(current.left);
			posOrder(current.rigth);
			System.out.println(current.value);
		}
	}

	public boolean isLeaft(Node01 node){
		if(node == null) return false;

		return node.left == null && node.rigth == null;
	}


}



class Node01{
	Node01 parent;
	Node01 left;
	Node01 rigth;
	int value;

	public Node01(int v){
		value = v;
	}


}