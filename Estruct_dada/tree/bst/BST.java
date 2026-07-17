public class BST{
	private Node root;

	public boolean isEmpty(){
		return this.root == null;
	}


	public void add(int v){
		Node novoNo = new Node(v);

		Node aux = this.root;

		if(isEmpty()){
		  this.root = novoNo;
		}else{
		  while(aux != null){
			if(v < aux.value){
			  if(aux.left == null){
				aux.left = novoNo;
				return;
			  }else aux = aux.left;

			}else{
			  if(aux.right == null){
				aux.right = novoNo;
				return;
			  }else aux = aux.right;
			}
		  }
		}
		
	}

  public int altura(){
    return altura(this.root);
  }

  private int altura(Node current){
    if(current == null) return -1;
    else return 1 + Math.max(altura(current.left), altura(current.right));
  }

	public Node search(int v){
		if(isEmpty()) return null;

		else return recursiveSearch(this.root, v);
	}
	
	public Node max(){
		if(isEmpty()) return null;
		else{
			Node aux = this.root;
			
			while(aux.right != null){
				aux = aux.right;
			}
			
		return aux;
		}
	}
	
	public Node mim(){
		if(isEmpty()) return null;
		else{
			Node aux = this.root;
			
			while(aux.left != null) aux = aux.left;
			
			return aux;
		}
	}
	
	public void preOrder(){
		preOrder(this.root);
	}
	
	private void preOrder(Node current){
		if(current != null){
			System.out.println(current.value + " ");
			preOrder(current.left);
			preOrder(current.right);
		}
	}
	
	
	public int size(){
		return size(this.root);
	}
	
	private int size(Node current){
		if(current == null) return 0;
		
		else return 1 + size(current.left) + size(current.right);
	}
	
	public void recursiveAdd(int v){
		if(isEmpty()) this.root = new Node(v);
		else rAdd(this.root, v);
	}
	
	private void rAdd(Node current, int v){
		if(v < current.value){
			if(current.left == null) {
				current.left = new Node(v);
				return;
			}
			else rAdd(current.left, v);
		} else{
			if(current.right == null) {
				current.right = new Node(v);
				return;
			}
			else rAdd(current.right, v);
		}
	}

	public Node recursiveSearch(Node current, int v){
		if(current  == null) return null;

		if(current.value == v) return current;

		if(current.value > v)
		  return recursiveSearch(current.left, v);
		else
		  return recursiveSearch(current.right, v);
	}

}

class Node{
	int value;
	Node left;
	Node right;

	Node(int value){
		this.value = value;
	}
}
